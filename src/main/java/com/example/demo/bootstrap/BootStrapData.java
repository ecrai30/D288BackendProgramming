package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    //Divisions
    Division division = divisionRepository.findById(7L).orElse(null);

    //Customers
    Customer melissa = new Customer();
    melissa.setFirstName("Melissa");
    melissa.setLastName("Craig");
    melissa.setAddress("342 Shelton Lane");
    melissa.setPostal_code("36598");
    melissa.setPhone("2569847516");
    melissa.setDivision(division);
    customerRepository.save(melissa);

    Customer leticia = new Customer();
    leticia.setFirstName("Leticia");
    leticia.setLastName("Marcela");
    leticia.setAddress("342 Brazil Lane");
    leticia.setPostal_code("26598");
    leticia.setPhone("2569877516");
    customerRepository.save(leticia);

    Customer christina = new Customer();
    christina.setFirstName("Christina");
    christina.setLastName("Craig");
    christina.setAddress("342 Mills Lane");
    christina.setPostal_code("36498");
    christina.setPhone("2569847556");
    customerRepository.save(christina);

    Customer richard = new Customer();
    richard.setFirstName("Richard");
    richard.setLastName("Craig");
    richard.setAddress("342 Lowry Lane");
    richard.setPostal_code("36098");
    richard.setPhone("2569847514");
    customerRepository.save(richard);

    Customer victor = new Customer();
    victor.setFirstName("Victor");
    victor.setLastName("Craig");
    victor.setAddress("342 Mills Lane");
    victor.setPostal_code("34598");
    victor.setPhone("2569647516");
    customerRepository.save(victor);


    }
}
