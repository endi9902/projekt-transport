package pl.dmcs.am.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findById(long id);
    List<Ticket> findByAppUser(AppUser appUser);
}
