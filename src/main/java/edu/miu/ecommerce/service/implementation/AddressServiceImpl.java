package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.AddressType;
import edu.miu.ecommerce.service.AddressService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Override
    public Address addAddress(Address address) {
        return null;
    }

    @Override
    public void deleteAddress(Address address) {

    }

    @Override
    public List<Address> getAddressesByType(AddressType addressType) {
        return null;
    }
}
