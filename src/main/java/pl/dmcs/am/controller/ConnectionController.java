package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.am.domain.Connection;
import pl.dmcs.am.domain.Ticket;
import pl.dmcs.am.service.AppUserService;
import pl.dmcs.am.service.ConnectionService;
import pl.dmcs.am.service.TicketService;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes
public class ConnectionController {
    private ConnectionService connectionService;
    private TicketService ticketService;
    private AppUserService appUserService;

    @Autowired
    public ConnectionController(ConnectionService connectionService,TicketService ticketService, AppUserService appUserService) {
        this.connectionService = connectionService;
        this.ticketService = ticketService;
        this.appUserService = appUserService;
    }

    @RequestMapping("/connections")
    public String listConnections(Model model, HttpServletRequest request) {

        int connectionId = ServletRequestUtils.getIntParameter(request, "connectionId", -1);

        if (connectionId > 0) {
            model.addAttribute("connection", connectionService.getConnection(connectionId));
        }else
            model.addAttribute("connection", new Connection());

        model.addAttribute("connectionList", connectionService.listConnection());

        return "connection";
    }

    @RequestMapping(value = "/addConnection", method = RequestMethod.POST)
    public String addConnection(@ModelAttribute("connection") Connection connection, BindingResult result, HttpServletRequest request) {
            connectionService.addConnection(connection);
        return "redirect:connections.html";
    }
    @RequestMapping(value = "/findConnection")
    public String showConnections(Model model, HttpServletRequest request) {
        model.addAttribute("connectionList", connectionService.listConnection());
        return "findConnection";
    }
    @RequestMapping(value = "/addingTicket/{connectionId}")
    public String addingTicket(@PathVariable("connectionId") Long connectionId,
                                  Model model,
                                  HttpServletRequest request) {
        Ticket ticket = new Ticket();
        Connection connection = connectionService.getConnection(connectionId);
        ticket.setAppUser(appUserService.findByLogin(request.getUserPrincipal().getName()));
        ticket.setConnection(connection);
        //model.addAttribute("ticket", ticketService.getTicket(ticketId));
        model.addAttribute("connectionList", connectionService.listConnection());
        ticketService.addTicket(ticket);
        return "redirect:/tickets.html";
    }
    @RequestMapping("/deleteConnection/{connectionId}")
    public String deleteConnection(@PathVariable("connectionId") Integer connectionId) {
        connectionService.removeConnection(connectionId);

        return "redirect:/connections.html";
    }
}
