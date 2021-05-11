package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")
public class Order extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
