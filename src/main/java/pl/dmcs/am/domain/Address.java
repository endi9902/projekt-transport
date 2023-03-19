package pl.dmcs.am.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String city;
    private String street;
    private String number;
    private String postalCode;

    @JsonBackReference
    @OneToOne(mappedBy = "address")
    //@JoinTable(name="appuser_address",joinColumns = @JoinColumn(name="appuser_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
    private AppUser appUser;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
