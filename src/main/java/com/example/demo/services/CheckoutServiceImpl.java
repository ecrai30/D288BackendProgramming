package com.example.demo.services;


import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order information
        Cart cart = purchase.getCart();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        //populate cart with cartItems
        Set<CartItem> cartItems =purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));
        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(cart);


        //save to the database
        customerRepository.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
        return null;
    }
    private String generateOrderTrackingNumber)(){

    //generate a random UUID numebr(UUID version -4)
        return UUID.randomUUID().toString();
    }
}
