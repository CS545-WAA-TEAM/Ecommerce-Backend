package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product, long id);

}
