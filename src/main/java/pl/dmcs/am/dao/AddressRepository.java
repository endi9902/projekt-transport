package pl.dmcs.am.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.am.domain.Address;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
}
