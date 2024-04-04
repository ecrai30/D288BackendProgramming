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
public class Divison {

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

    @Column(name = "country_id")
    private BigInteger country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy =  "division")
    private Set<Customer> customers;


}
