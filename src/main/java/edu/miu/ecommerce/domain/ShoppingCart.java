package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart extends Audit{

    @Id
    long id;

    @OneToOne(mappedBy = "buyer_cart")
    private Buyer buyer;

    @OneToMany(mappedBy = "cart_products")
    private List<Product> products;
}
