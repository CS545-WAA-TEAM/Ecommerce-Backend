package edu.miu.ecommerce.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DataLoader implements CommandLineRunner {

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
//        TODO
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
