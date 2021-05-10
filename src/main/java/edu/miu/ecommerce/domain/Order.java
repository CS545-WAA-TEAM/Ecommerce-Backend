package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @OneToOne
    private Address shippingAddress;

    @OneToOne
    private Address billingAddress;


}
