package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Product;


public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProductById(long id);

    Product addProduct(Product product);

    void deleteProduct(long id);

    void updateProduct(Product product, long id);

}
