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
public class Product extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @ManyToOne
    private Seller seller;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Order> orders;

    @OneToMany
    private Set<Review> reviews;

}
