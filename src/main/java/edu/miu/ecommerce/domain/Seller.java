package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {

    @Column(name = "fullName")
    private String fullName;

    @Column
    private boolean isApproved;

    @OneToMany(mappedBy = "seller")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Product> products;

}
