package com.example.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Buyer{

    @Id
    long Id;

    @OneToMany(mappedBy= "buyer")
    private List<Order> orders;

//    @OneToMany(mappedBy= "buyer")
//    private ShoppingCart shoppingCart;


}
