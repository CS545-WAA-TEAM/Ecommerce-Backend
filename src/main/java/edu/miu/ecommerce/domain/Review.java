package edu.miu.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column
    private boolean isApproved;

    @ManyToOne
    private Buyer buyer;

    private String content;

    @ManyToOne
    private Product product;
}
