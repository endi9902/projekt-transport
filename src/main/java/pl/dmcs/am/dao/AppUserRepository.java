package pl.dmcs.am.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.am.domain.AppUser;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

    @Transactional
    @Repository
    public interface AppUserRepository extends JpaRepository<AppUser, Long> {

        List<AppUser> findByLastName(String lastName);
        AppUser findById(long id);
        AppUser findByLogin(String login);

    }
