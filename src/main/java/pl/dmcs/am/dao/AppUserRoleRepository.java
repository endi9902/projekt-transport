package pl.dmcs.am.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.am.domain.AppUserRole;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByRole(String role);
}

