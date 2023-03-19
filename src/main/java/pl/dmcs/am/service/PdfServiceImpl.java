package pl.dmcs.am.service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import pl.dmcs.am.domain.AppUser;
import pl.dmcs.am.domain.Ticket;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    public void generatePdf(Ticket ticket, HttpServletResponse response) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + ticket.getAppUser()+ ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("BILET"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("FirstName");
            table.addCell(ticket.getAppUser().getFirstName());
            table.addCell("LastName");
            table.addCell(ticket.getAppUser().getLastName());
            table.addCell("Login");
            table.addCell(ticket.getAppUser().getLogin());
            table.addCell("Email");
            table.addCell(ticket.getAppUser().getEmail());
            table.addCell("StartStation");
            table.addCell(ticket.getConnection().getStartStation());
            table.addCell("EndStation");
            table.addCell(ticket.getConnection().getEndStation());
            table.addCell("Date");
            table.addCell(ticket.getConnection().getDate().toString());
            table.addCell("Time");
            table.addCell(ticket.getConnection().getTime().toString());
            table.addCell("Price (PLN)");
            table.addCell(ticket.getConnection().getPrice());
            pdf.add(table);
            pdf.close();
            o.close();
        }catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
