package edu.miu.ecommerce.util;

import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.repository.BuyerDAO;
import edu.miu.ecommerce.repository.ProductDAO;
import edu.miu.ecommerce.repository.SellerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BuyerDAO buyerDAO;
    @Autowired
    private SellerDAO sellerDAO;
    @Autowired
    ProductDAO productDAO;

    @Override
    public void run(String... args) throws Exception {
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
    }

    private void createSellers(){
        Seller seller1 = new Seller("Bob Saget", true, null, null);
        Seller seller2 = new Seller("Dave Portnoy", true, null, null);
        Seller seller3 = new Seller("Tony Soprano", true, null, null);
        sellerDAO.saveAll(Arrays.asList(seller1, seller2, seller3));
        System.out.println(sellerDAO.findAll().toString());
        sellerDAO.findAll().forEach(seller -> System.out.println(seller.getCreatedDate()));
    }

    private void createBuyers(){
        
//        TODO
    }

    private void createAdmins(){
//        TODO
    }

    private void createProducts(){
//        TODO
    }

    private void createOrders(){
//        TODO
    }

    private void createReviews(){
//        TODO
    }

}
