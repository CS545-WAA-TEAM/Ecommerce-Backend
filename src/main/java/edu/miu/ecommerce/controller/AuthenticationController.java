package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.configuration.security.CustomUserDetailsService;
import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.model.AuthenticationRequest;
import edu.miu.ecommerce.model.AuthenticationResponse;
import edu.miu.ecommerce.model.UserRegistrationRequest;
import edu.miu.ecommerce.service.BuyerService;
import edu.miu.ecommerce.service.SellerService;
import edu.miu.ecommerce.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()
            ));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        if (userRegistrationRequest.isBuyer()) {
            Buyer buyer = new Buyer();
            Set<Order> orders = new HashSet<>();
            Set<Address> addresses = new HashSet<>();
            Set<Review> reviews = new HashSet<>();
            buyer.setUsername(userRegistrationRequest.getUsername());
            buyer.setFullName(userRegistrationRequest.getFullName());
            buyer.setBalance(0);
            buyer.setOrders(orders);
            buyer.setAddresses(addresses);
            buyer.setReviews(reviews);
            buyerService.addBuyer(buyer);

        }
        if (userRegistrationRequest.isSeller()) {
            Seller seller = new Seller();
            Set<Order> orders = new HashSet<>();
            Set<Product> products = new HashSet<>();
            seller.setUsername(userRegistrationRequest.getUsername());
//            seller.setOrders(orders);
            seller.setProducts(products);
            seller.setApproved(false);
            sellerService.addSeller(seller);

        }


    }
}
