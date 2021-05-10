package com.example.ecommerce.domain;

import javax.persistence.Id;
import java.util.List;


public class Admin {

    @Id
    long id;

    private List<Review> reviews;

    private List<Seller> sellers;

    //approves seller
    //approves reviews
}
