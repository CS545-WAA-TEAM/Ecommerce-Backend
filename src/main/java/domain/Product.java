package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    Long id;

    private String product_name;

    private String product_description;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

//    isPurchased
}
