package edu.miu.ecommerce.util;

import edu.miu.ecommerce.domain.Role;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.repository.BuyerDAO;
import edu.miu.ecommerce.repository.ProductDAO;
import edu.miu.ecommerce.repository.RoleDAO;
import edu.miu.ecommerce.repository.SellerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BuyerDAO buyerDAO;
    @Autowired
    private SellerDAO sellerDAO;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    RoleDAO roleDAO;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
    }

    private void createSellers(){
        Seller seller1 = new Seller("Bob Saget", true, null, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(2L).get());
        seller1.setUsername("bob");
        seller1.setPassword(new BCryptPasswordEncoder().encode("saget"));
        seller1.setRoles(roleSet);
        sellerDAO.saveAll(Arrays.asList(seller1));
        System.out.println(sellerDAO.findAll().toString());
    }

    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN", null);
        Role roleSeller = new Role(2,"ROLE_SELLER", null);
        Role roleBuyer = new Role(3,"ROLE_BUYER", null);

        roleDAO.saveAll(Arrays.asList(roleAdmin, roleSeller, roleBuyer));
        System.out.println(roleDAO.findAll().toString());
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
