package pl.dmcs.am.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.am.domain.AppUserRole;
import pl.dmcs.am.service.AppUserRoleService;

import java.util.HashSet;
import java.util.Set;

public class AppUserRoleConverter implements Converter<String, Set<AppUserRole>> {

    private AppUserRoleService appUserRoleService;

    @Autowired
    public AppUserRoleConverter(AppUserRoleService appUserRoleService) {
        this.appUserRoleService = appUserRoleService;
    }

    @Override
    public Set<AppUserRole> convert(String source) {

        Set<AppUserRole> userRoleList = new HashSet<AppUserRole>(0);

        userRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source)));

        return userRoleList;
    }
}
