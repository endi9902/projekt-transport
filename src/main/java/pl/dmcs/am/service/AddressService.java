package pl.dmcs.am.service;

import pl.dmcs.am.domain.Address;

import java.util.List;

public interface AddressService {

    public void addAddress(Address address);
    public void editAddress(Address address);
    public void removeAddress(long id);
    public Address getAddress(long id);

}

