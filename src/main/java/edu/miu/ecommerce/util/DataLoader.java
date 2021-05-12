package edu.miu.ecommerce.util;

import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Autowired
    OrderDAO orderDAO;

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
        Seller seller1 = new Seller("Bob Saget", true, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(2L).get());
        seller1.setId(1);
        seller1.setUsername("bob");
        seller1.setPassword(new BCryptPasswordEncoder().encode("saget"));
        seller1.setRoles(roleSet);
        sellerDAO.saveAll(Arrays.asList(seller1));
        System.out.println(sellerDAO.findAll().toString());
        System.out.println(StreamSupport.stream(sellerDAO.findAll().spliterator(),false).collect(Collectors.toList()).get(0).getId());
    }

    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN");
        Role roleSeller = new Role(2,"ROLE_SELLER");
        Role roleBuyer = new Role(3,"ROLE_BUYER");

        roleDAO.saveAll(Arrays.asList(roleAdmin, roleSeller, roleBuyer));
        System.out.println(roleDAO.findAll().toString());
    }

    private void createBuyers(){
//        TODO

        Buyer buyer = new Buyer(0,"blen",null,null,new HashSet<>(),null,null);
        buyerDAO.save(buyer);
        System.out.println(buyerDAO.findAll().toString());
        System.out.println(StreamSupport.stream(buyerDAO.findAll().spliterator(),false).collect(Collectors.toList()).get(0).getId());
    }

    private void createAdmins(){
//        TODO
    }

    private void createProducts(){
//        TODO
        Optional<Seller> seller = sellerDAO.findById(4L);
        Set<Order> orders = new HashSet<>();
        Set<Review> reviews = new HashSet<>();
        Product product = new Product(1,"Hat","Just do it", 4, seller.get(), orders,reviews);
        Product product1 = new Product(2,"Test","Test ", 4, seller.get(), orders,reviews);
        productDAO.saveAll(Arrays.asList(product,product1));
        System.out.println(productDAO.findAll().toString());

    }

    private void createOrders(){
//        TODO
        Optional<Buyer> buyer = buyerDAO.findById(5L);
        Optional<Product> product = productDAO.findById(6L);
        System.out.println(buyer.get());
        System.out.println(product.get());
        Order order = new Order();
        order.setStatus(OrderStatus.ORDERED);
        order.setProduct(product.get());
        order.setBuyer(buyer.get());
        orderDAO.save(order);
        System.out.println(order.toString());
        System.out.println(orderDAO.findAll().toString());
    }

    private void createReviews(){
//        TODO
    }

}
