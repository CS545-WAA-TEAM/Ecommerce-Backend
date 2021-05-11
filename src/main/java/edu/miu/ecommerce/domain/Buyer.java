package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends User{

    @Column(name = "balance")
    private float balance;

    @Column(name = "fullName")
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_cart")
    private ShoppingCart shoppingCart;

    @OneToMany
    @JoinTable
    private Set<Seller> following;

    @OneToMany(mappedBy= "buyer")
    private Set<Order> orders;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Review> reviews;
}
