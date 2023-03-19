package pl.dmcs.am.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmcs.am.dao.AppUserRepository;

import pl.dmcs.am.dao.AppUserRoleRepository;
import pl.dmcs.am.domain.AppUser;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;
    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserRoleRepository appUserRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appUserRoleRepository = appUserRoleRepository;
    }

    @Transactional
    public void addAppUser(AppUser appUser) {
        appUser.setEnabled(true);
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("USER"));
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Transactional
    public void editAppUser(AppUser appUser) {
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    private String hashPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Transactional
    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    @Transactional
    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    @Transactional
    public AppUser getAppUser(long id) {
        return appUserRepository.findById(id);
    }

    @Transactional
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }

}

