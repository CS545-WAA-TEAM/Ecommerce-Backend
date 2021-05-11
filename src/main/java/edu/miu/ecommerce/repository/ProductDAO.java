package edu.miu.ecommerce.repository;

import edu.miu.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {
}
