package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartDAO extends CrudRepository<ShoppingCart, Long> {
}
