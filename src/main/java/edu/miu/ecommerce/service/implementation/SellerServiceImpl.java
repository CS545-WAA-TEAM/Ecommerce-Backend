package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.repository.SellerDAO;
import edu.miu.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerDAO sellerDAO;

    @Override
    public Iterable<Seller> getAllSellers() {
        return sellerDAO.findAll();
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
}
