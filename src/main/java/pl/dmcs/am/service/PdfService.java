package pl.dmcs.am.service;

import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.Ticket;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(Ticket ticket, HttpServletResponse response);
}
