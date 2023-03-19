package pl.dmcs.am.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    //private String price;
    private Date createTicketDate = new Date();
    private boolean isPaid = false;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Connection connection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Date getCreateTicketDate() {
        return createTicketDate;
    }

    public void setCreateTicketDate(Date createTicketDate) {
        this.createTicketDate = createTicketDate;
    }
}
