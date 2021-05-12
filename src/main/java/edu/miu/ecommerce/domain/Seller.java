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
public class Seller extends User {

    @Column(name = "fullName")
    private String fullName;

    @Column
    private boolean isApproved;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.EAGER)
//    private Set<Order> orders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
    private Set<Product> products;

}
