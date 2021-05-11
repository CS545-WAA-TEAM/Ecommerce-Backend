package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Buyer extends User{

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
    @JoinColumn(name = "buyer_cart", nullable = false)
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
