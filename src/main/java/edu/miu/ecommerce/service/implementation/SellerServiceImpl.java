package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.repository.SellerDAO;
import edu.miu.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerDAO sellerDAO;

    @Override
    public List<Seller> getAllSellers() {
        return StreamSupport.stream(sellerDAO.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Seller getSellerById(long id) {
        return sellerDAO.findById(id).orElseThrow();
    }

    @Override
    public Seller addSeller(Seller seller) {
        return sellerDAO.save(seller);
    }

    @Override
    public void deleteSeller(long id) {
        sellerDAO.deleteById(id);
    }

    @Override
    public List<Product> findProducts(long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product, long id) {
        Set<Product> products = new HashSet<>();
        products.add(product);
        Seller seller = getSellerById(id);
        seller.setProducts(products);
        sellerDAO.save(seller);
        return product;
    }

}
