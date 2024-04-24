package com.example.demo.entities;

import com.example.demo.validators.FormValidator;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@FormValidator
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message ="First name must not be null, empty value/space can be considered")
    @NonNull
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @NotEmpty(message ="Last name must not be null, empty value/space can be considered" )
    @NonNull
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @NotEmpty
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @NonNull
    @NotEmpty
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotEmpty
    @NonNull
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name ="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy =  "customer")
    private Set<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;


    public void add(Cart cart) {
        if (cart != null) {
            if(carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }

    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Division division){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = division;

    }

    public Customer(){

    }


}
