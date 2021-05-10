package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User {

    @Id
    long Id;

    @OneToMany(mappedBy = "seller")
    private List<Order> orders;

    @OneToMany(mappedBy = "product")
    private List<Product> products;

    private String fullName;
}
