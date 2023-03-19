package pl.dmcs.am.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private int version;

    @NotNull
    @Column(name="firstName", nullable=false)
    @Size(min=2, max=30, message = "{error.size.firstName}")
    private String firstName;

    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    @NotNull
    private String email;

    @Size(min=9, max=9)
    private String telephone;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    @JsonIgnore
    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Ticket> ticketList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }
    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}

