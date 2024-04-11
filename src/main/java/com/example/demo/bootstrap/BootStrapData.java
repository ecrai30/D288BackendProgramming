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
        if(customerRepository.count() > 1 || divisionRepository.findById(7L).isEmpty()) {
            return;
        }

        else{

                //Divisions//Customers
                Division division1 = divisionRepository.findById(7L).orElse(null);
                Customer melissa = new Customer();
                melissa.setFirstName("Melissa");
                melissa.setLastName("Craig");
                melissa.setAddress("342 Shelton Lane");
                melissa.setPostal_code("36598");
                melissa.setPhone("2569847516");
                melissa.setDivision(division1);
                customerRepository.save(melissa);

                Division division2 = divisionRepository.findById(26L).orElse(null);
                Customer leticia = new Customer();
                leticia.setFirstName("Leticia");
                leticia.setLastName("Marcela");
                leticia.setAddress("342 Brazil Lane");
                leticia.setPostal_code("26598");
                leticia.setPhone("2569877516");
                leticia.setDivision(division2);
                customerRepository.save(leticia);

                Division division3 = divisionRepository.findById(39L).orElse(null);
                Customer christina = new Customer();
                christina.setFirstName("Christina");
                christina.setLastName("Craig");
                christina.setAddress("342 Mills Lane");
                christina.setPostal_code("36498");
                christina.setPhone("2569847556");
                christina.setDivision(division3);
                customerRepository.save(christina);

                Division division4 = divisionRepository.findById(6L).orElse(null);
                Customer richard = new Customer();
                richard.setFirstName("Richard");
                richard.setLastName("Craig");
                richard.setAddress("342 Lowry Lane");
                richard.setPostal_code("36098");
                richard.setPhone("2569847514");
                richard.setDivision(division4);
                customerRepository.save(richard);

                Division division5 = divisionRepository.findById(10L).orElse(null);
                Customer victor = new Customer();
                victor.setFirstName("Victor");
                victor.setLastName("Craig");
                victor.setAddress("342 Mills Lane");
                victor.setPostal_code("34598");
                victor.setPhone("2569647516");
                victor.setDivision(division5);
                customerRepository.save(victor);
            }
        }
    }

