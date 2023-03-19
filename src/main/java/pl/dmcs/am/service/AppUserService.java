package pl.dmcs.am.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.am.domain.AppUser;

import java.util.List;

public interface AppUserService {

    void addAppUser(AppUser user);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
    void editAppUser(AppUser user);

    List<AppUser> listAppUser();

    @Secured("ROLE_ADMIN")
    void removeAppUser(long id);

    AppUser getAppUser(long id);

    AppUser findByLogin(String login);
}
