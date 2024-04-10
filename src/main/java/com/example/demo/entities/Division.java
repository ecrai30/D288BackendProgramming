package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Table(name = "divisions")
@Entity
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;


    //Define one-to-many relationship for Customer
    @OneToMany(cascade=CascadeType.ALL, mappedBy =  "division")
    private Set<Customer> customers;

    //Define many-to-one relationship for Country
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    //Fix for front end not population divisions
    @Column(name = "country_id")
    private long country_id;
    public void setCountry(Country country){
        setCountry_id(country.getId());
        this.country = country;
    }

}
