package pl.dmcs.am.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.am.dao.AddressRepository;
import pl.dmcs.am.domain.Address;

import javax.transaction.Transactional;
import java.util.List;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Transactional
    public void editAddress(Address address) {
        addressRepository.save(address);
    }

    @Transactional
    public void removeAddress(long id) {
        addressRepository.delete(id);
    }

    @Transactional
    public Address getAddress(long id) {
        return addressRepository.findById(id);
    }
}
