package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.service.AddressService;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/addresses")
    public String listAddresses(Model model, HttpServletRequest request) {

        int addressId = ServletRequestUtils.getIntParameter(request, "addressId" , -1);

        if (addressId > 0)
            model.addAttribute("address", addressService.getAddress(addressId));
        else
            model.addAttribute("address", new Address());

        return "address";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("address") Address address, BindingResult result, HttpServletRequest request) {

        if (address.getId()==0)
            addressService.addAddress(address);
        else
            addressService.editAddress(address);

        return "redirect:addresses.html";
    }

    @RequestMapping("/deleteAddress/{addressId}")
    public String deleteAddress(@PathVariable("addressId") Integer addressId) {
        addressService.removeAddress(addressId);

        return "redirect:/addresses.html";
    }

}
