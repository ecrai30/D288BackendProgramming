package com.example.demo.services;


import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
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
        cartRepository.save(cart);
        cart.setStatus(ordered);

        //Checks to see if cart is empty and return a response
        if (purchase.getCartItems().isEmpty()) {
            return new PurchaseResponse("Cart is Empty!");
        }
        else{
            return new PurchaseResponse(orderTrackingNumber);
        }



    }
    private String generateOrderTrackingNumber(){

    //generate a random UUID number(UUID version -4)
        return UUID.randomUUID().toString();
    }
}
