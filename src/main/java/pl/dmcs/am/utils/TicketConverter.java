package pl.dmcs.am.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.am.domain.Ticket;
import pl.dmcs.am.service.TicketService;

public class TicketConverter implements Converter<String, Ticket> {

    private TicketService ticketService;

    @Autowired
    public TicketConverter(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public Ticket convert(String source) {
        return ticketService.getTicket(Integer.parseInt(source));
    }
}