package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;

import java.util.List;


public interface SellerService {

    List<Seller> getAllSellers();

    Seller getSellerById(long id);

    Seller addSeller(Seller seller);

    void deleteSeller(long id);

    List<Product> findProducts(long id);

    Product addProduct(Product product, long id);


}
