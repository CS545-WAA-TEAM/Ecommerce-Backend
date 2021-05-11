package edu.miu.ecommerce.domain;

import javax.persistence.*;

@Entity
public class Address extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "country")
    private String country;

    private AddressType addressType;

}
