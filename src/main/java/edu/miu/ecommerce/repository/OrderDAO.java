package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order,Long> {
}
