package com.example.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Seller {

    @Id
    long Id;

    @OneToMany(mappedBy = "seller")
    private Set<Order> orders;

    @OneToMany(mappedBy = "product")
    private Set<Product> products;

    //CRUD product
}
