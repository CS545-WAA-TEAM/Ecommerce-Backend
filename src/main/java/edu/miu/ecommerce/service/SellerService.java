package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerService {

    Iterable<Seller> getAllSellers();

    Seller getSellerById(long id);

    Seller addSeller(Seller seller);

    void deleteSeller(long id);

    List<Product> findProducts(long id);


}
