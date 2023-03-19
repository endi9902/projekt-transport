package pl.dmcs.am.service;

import pl.dmcs.am.domain.AppUserRole;

import java.util.List;

public interface AppUserRoleService {

    public void addAppUserRole(AppUserRole appUserRole);
    public List<AppUserRole> listAppUserRole();
    public AppUserRole getAppUserRole(long id);

}
