package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    long id;

    @OneToMany(mappedBy = "order")
    private List<Order> orders;
}
