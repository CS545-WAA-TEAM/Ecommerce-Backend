package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Order {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="order_id")
    private ShoppingCart shoppingCart;


    private LocalDate createdDate;

//    crud
}
