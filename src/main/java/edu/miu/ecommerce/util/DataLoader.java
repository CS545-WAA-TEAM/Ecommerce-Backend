package edu.miu.ecommerce.util;

import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.repository.*;
import edu.miu.ecommerce.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private SellerDAO sellerDAO;

    @Autowired

    private BuyerDAO buyerDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Autowired
    SellerService sellerService;

    @Override
    public void run(String... args) throws Exception {
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
    }

    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN", null);
        Role roleSeller = new Role(2,"ROLE_SELLER", null);
        Role roleBuyer = new Role(3,"ROLE_BUYER", null);

        roleDAO.saveAll(Arrays.asList(roleAdmin, roleSeller, roleBuyer));
        System.out.println(roleDAO.findAll().toString());
    }

    private void createSellers(){
        Seller seller = new Seller("Bob Saget", true, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(2L).get());
        seller.setUsername("bob");
        seller.setPassword(new BCryptPasswordEncoder().encode("saget"));
        seller.setRoles(roleSet);
        sellerDAO.saveAll(Arrays.asList(seller));
        StreamSupport.stream(sellerDAO.findAll().spliterator(),false)
                .forEach(seller1 -> System.out.println("Seller ID: " + seller1.getId() + " Seller Username: " + seller1.getUsername()));
        System.out.println("Seller Password: saget");
    }

    private void createBuyers(){
        Buyer buyer = new Buyer(0,"Blen Aklilu",null,null,null,null,null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(3L).get());
        buyer.setUsername("blen");
        buyer.setPassword(new BCryptPasswordEncoder().encode("aklilu"));
        buyer.setRoles(roleSet);
        Buyer savedBuyer = buyerDAO.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(savedBuyer);
        shoppingCartDAO.save(shoppingCart);
        StreamSupport.stream(buyerDAO.findAll().spliterator(),false)
                .forEach(buyer1 -> System.out.println("Buyer ID: " + buyer1.getId() + " Buyer Username: " + buyer1.getUsername()));
        System.out.println("Buyer Password: aklilu");

    }

    private void createAdmins(){
        Admin admin = new Admin();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(1L).get());
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        admin.setRoles(roleSet);
        adminDAO.save(admin);
        StreamSupport.stream(adminDAO.findAll().spliterator(),false)
                .forEach(admin1 -> System.out.println("Admin ID: " + admin1.getId() + " Admin Username: " + admin1.getUsername()));
        System.out.println("Buyer Password: admin");

    }

    private void createProducts(){

        Product product = new Product(1,"Hat","Just do it", 4, null, null, null);
        Product product1 = new Product(2,"Jacket","Virginia Beach", 4, null, null, null);
        sellerService.addProduct(product1, 5L);
        sellerService.addProduct(product, 5L);
        System.out.println(productDAO.findAll().toString());
    }

    private void createOrders(){

        Optional<Buyer> buyer = buyerDAO.findById(6L);
        Optional<Product> product = productDAO.findById(8L);
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
