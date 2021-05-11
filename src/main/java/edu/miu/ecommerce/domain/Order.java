package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="Orders")
public class Order extends Audit{

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

    @ManyToOne
    private Product product;

    @OneToOne
    private Address shippingAddress;

    @OneToOne
    private Address billingAddress;


}
