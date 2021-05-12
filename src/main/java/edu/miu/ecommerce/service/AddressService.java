package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.AddressType;

import java.util.List;


public interface AddressService {

    Address addAddress(Address address);

    void deleteAddress(Address address);

    //TODO update

    List<Address> getAddressesByType(AddressType addressType);
}
