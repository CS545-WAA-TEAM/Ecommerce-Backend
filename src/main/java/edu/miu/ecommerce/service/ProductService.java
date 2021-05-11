package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProductById(long id);

    Product addProduct(Product product);

    void deleteProduct(long id);

    void updateProduct(Product product, long id);

}
