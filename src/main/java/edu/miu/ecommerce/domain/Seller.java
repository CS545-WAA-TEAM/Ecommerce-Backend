package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Seller extends User {

    @OneToMany(mappedBy = "seller")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Product> products;

    @Column(name = "fullName")
    private String fullName;
}
