package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.AddressType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address addAddress(Address address);

    void deleteAddress(Address address);

    //TODO update

    List<Address> getAddressesByType(AddressType addressType);
}
