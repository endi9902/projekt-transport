package pl.dmcs.am.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.dmcs.am.dao.AddressRepository;
import pl.dmcs.am.dao.TicketRepository;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.Ticket;

import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private AppUserService appUserService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, AppUserService appUserService) { this.ticketRepository = ticketRepository;
    this.appUserService = appUserService;}

    @Transactional
    public void addTicket(Ticket ticket) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserService.findByLogin(authentication.getName());
        ticket.setAppUser(appUser);
        ticketRepository.save(ticket);
    }

    @Transactional
    public List<Ticket> listTicket() {
        return ticketRepository.findAll();
    }

    @Transactional
    public void removeTicket(long id) {
        ticketRepository.delete(id);
    }

    @Transactional
    public Ticket getTicket(long id) {
        return ticketRepository.findById(id);
    }

    @Transactional
    public void payForTicket(Ticket ticket) {
        ticket.setPaid(true);
        ticketRepository.save(ticket);
    }
    @Transactional
    public List<Ticket> listTicketByAppUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserService.findByLogin(authentication.getName());
        return ticketRepository.findByAppUser(appUser);
    }
}
