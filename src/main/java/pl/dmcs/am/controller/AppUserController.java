package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.AppUserRole;
import pl.dmcs.am.service.AddressService;
import pl.dmcs.am.service.AppUserRoleService;
import pl.dmcs.am.service.AppUserService;
import pl.dmcs.am.service.ReCaptchaService;
import pl.dmcs.am.validator.AppUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

@Controller
@SessionAttributes
public class AppUserController {
    private AppUserValidator appUserValidator = new AppUserValidator();

    private AppUserService appUserService;
    private AddressService addressService;
    private AppUserRoleService appUserRoleService;
    private ReCaptchaService reCaptchaService;

    @Autowired
    public AppUserController(AppUserService appUserService, AddressService addressService, AppUserRoleService appUserRoleService, ReCaptchaService reCaptchaService) {
        this.appUserService = appUserService;
        this.addressService = addressService;
        this.appUserRoleService = appUserRoleService;
        this.reCaptchaService = reCaptchaService;
    }
    @RequestMapping(value = "/adminPanel")
    public String appUsersList(Model model, HttpServletRequest request) {
        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());
        return "adminPanel";
    }

    @RequestMapping(value = "/appUsers")
    public String showAppUsers(Model model, HttpServletRequest request) {

        int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId" , -1);

        if (appUserId > 0){
            AppUser appUser = appUserService.getAppUser(appUserId);
            appUser.setPassword("");
            appUser.setAddress(addressService.getAddress(appUserService.getAppUser(appUserId).getAddress().getId()));
            model.addAttribute("selectedAddress", appUserService.getAppUser(appUserId).getAddress().getId());
            model.addAttribute("appUser", appUser);
        }
        else
            model.addAttribute("appUser", new AppUser());

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());

        return "appUser";
    }
    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model,
                             HttpServletRequest request) {

        appUserValidator.validate(appUser, result);
        if (result.getErrorCount() == 0 && reCaptchaService.verify(request.getParameter("g-recaptcha-response"))) {
                appUserService.addAppUser(appUser);

            return "redirect:appUsers.html";
        }

        appUser.getAppUserRole().clear();

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList",appUserRoleService.listAppUserRole());
        return "appUser";
    }
    @RequestMapping("/edit/{appUserId}")
    public String editUser(@PathVariable("appUserId") Long appUserId) {
        AppUser appUser = appUserService.getAppUser(appUserId);
        appUserService.editAppUser(appUser);
        return "redirect:/appUsers.html";
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") Long appUserId) {
        appUserService.removeAppUser(appUserId);
        return "redirect:/appUsers.html";
    }
}
