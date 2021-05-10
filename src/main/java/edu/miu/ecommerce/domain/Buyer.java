package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer extends User{

    @Id
    long Id;

    @Column(name = "balance")
    private float balance;

    @Column(name = "fullName")
    private String fullName;

    @OneToMany
    @JoinTable
    private Set<Seller> following;

    @OneToMany(mappedBy= "buyer")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
