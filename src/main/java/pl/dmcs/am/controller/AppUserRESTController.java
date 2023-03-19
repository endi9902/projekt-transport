package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dmcs.am.dao.AppUserRepository;
import pl.dmcs.am.domain.AppUser;

@RestController
@RequestMapping("appUserRest")
public class AppUserRESTController {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserRESTController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET, produces = "application/json")
    public AppUser getAppUserInJSON(@PathVariable String login) {
        return appUserRepository.findByLogin(login);
    }

    @RequestMapping(value = "/{login}.xml", method = RequestMethod.GET, produces = "application/xml")
    public AppUser getAppUserInXML(@PathVariable String login) {

        return appUserRepository.findByLogin(login);
    }

}