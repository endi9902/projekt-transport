package pl.dmcs.am.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.domain.Connection;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    Connection findById(long id);
}
