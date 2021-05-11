package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address,Long> {
}
