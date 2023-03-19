package pl.dmcs.am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.am.domain.Ticket;
import pl.dmcs.am.service.AppUserService;
import pl.dmcs.am.service.PdfService;
import pl.dmcs.am.service.TicketService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    private PdfService pdfService;
    private TicketService ticketService;

    @Autowired
    public PdfController(PdfService pdfService, TicketService ticketService) {
        this.pdfService = pdfService;
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/generatePdf-{ticketId}", method = RequestMethod.GET)
    public void generatePdf(@PathVariable Long ticketId, HttpServletResponse response) {
        Ticket ticket = ticketService.getTicket(ticketId);
        pdfService.generatePdf(ticket, response);
    }
}