package pl.dmcs.am.service;

import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.am.dao.TicketRepository;
import pl.dmcs.am.domain.Ticket;

import java.util.List;

public interface TicketService {
    public void addTicket(Ticket ticket);

    //@PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
    public List<Ticket> listTicket();
    public void removeTicket(long id);
    public Ticket getTicket(long id);
    public void payForTicket(Ticket ticket);
    public List<Ticket> listTicketByAppUser();
}
