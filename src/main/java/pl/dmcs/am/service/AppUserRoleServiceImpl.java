package pl.dmcs.am.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.am.dao.AppUserRoleRepository;
import pl.dmcs.am.domain.AppUserRole;

import javax.transaction.Transactional;
import java.util.List;

@Service("appUserRoleService")
public class AppUserRoleServiceImpl implements AppUserRoleService {

    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    public AppUserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

    @Transactional
    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    @Transactional
    public List<AppUserRole> listAppUserRole() {
        return appUserRoleRepository.findAll();
    }

    @Transactional
    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }
}

