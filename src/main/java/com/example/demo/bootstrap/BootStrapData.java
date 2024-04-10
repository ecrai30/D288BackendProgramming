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

       /** Divison division1 = divisionRepository.findById(1L).orElse(null);
        division1.setId(1L);
        division1.setDivision_name("Test");
        division1.setCountry("USA");
        DivisionRepository.save(division1);
    */
       Division division1 = new Division();

        Customer melissa = new Customer("Melissa","Craig", "342 Shelton Lane","45679", "1235467890");
        melissa.getId().add(division1);
        CustomerRepository.save(melissa);


        System.out.println(CustomerRepository.findAll());


    }
}
