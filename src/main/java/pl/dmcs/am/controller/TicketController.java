package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.Connection;
import pl.dmcs.am.domain.Ticket;
import pl.dmcs.am.service.AddressService;
import pl.dmcs.am.service.AppUserService;
import pl.dmcs.am.service.ConnectionService;
import pl.dmcs.am.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes
public class TicketController {

    private TicketService ticketService;
    private AppUserService appUserService;
    private ConnectionService connectionService;

    @Autowired
    public TicketController(TicketService ticketService, AppUserService appUserService, ConnectionService connectionService){
        this.ticketService = ticketService;
        this.appUserService = appUserService;
        this.connectionService = connectionService;
    }

    @RequestMapping("/tickets")
    public String listTicket(Model model,
                              HttpServletRequest request) {

        int ticketId = ServletRequestUtils.getIntParameter(request, "ticketId" , -1);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (ticketId > 0) {
            Ticket ticket = ticketService.getTicket(ticketId);
            ticket.setAppUser(appUserService.getAppUser(ticketService.getTicket(ticketId).getAppUser().getId()));
            ticket.setConnection(connectionService.getConnection(ticketService.getTicket(ticketId).getConnection().getId()));
            model.addAttribute("appUser", appUserService.findByLogin(authentication.getName()).getId());
            model.addAttribute("selectedConnection", ticketService.getTicket(ticketId).getConnection().getId());
            model.addAttribute("ticket", ticketService.getTicket(ticketId));
        }else {
            model.addAttribute("ticket", new Ticket());
        }
        model.addAttribute("ticketList", ticketService.listTicketByAppUser());
        model.addAttribute("connectionList", connectionService.listConnection());
        model.addAttribute("appUser",appUserService.findByLogin(authentication.getName()));
        return "ticket";
    }
    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public String addTicket(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult result, Model model,
                            HttpServletRequest request) {

        ticketService.addTicket(ticket);
       // model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("connection", connectionService.listConnection());
        model.addAttribute("ticketList", ticketService.listTicket());

        return "redirect:tickets.html";
    }
    @RequestMapping(value = "/pay-{ticketId}")
    public String payTicket(@PathVariable("ticketId") Long ticketId) {

        Ticket ticket = ticketService.getTicket(ticketId);
        ticketService.payForTicket(ticket);
        return "redirect:tickets.html";
    }
    @Scheduled(fixedRate = 1000)
    public void reverseTicket(){
        for(Ticket ticket : ticketService.listTicket()){
            if(!ticket.isPaid()){
                if((new Date().getTime() - ticket.getCreateTicketDate().getTime() > 86400000)){
                    ticketService.removeTicket(ticket.getId());
                }
            }
        }
    }
}
