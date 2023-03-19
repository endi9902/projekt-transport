package pl.dmcs.am.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.service.AddressService;

public class AddressConverter implements Converter<String, Address> {

    private AddressService addressService;

    @Autowired
    public AddressConverter(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public Address convert(String source) {
        return addressService.getAddress(Integer.parseInt(source));
    }
}

