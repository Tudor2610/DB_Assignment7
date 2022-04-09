package com.homework.db_assignment7.services;

import com.homework.db_assignment7.models.Customer;
import com.homework.db_assignment7.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Optional<Customer> getCustomerById(Integer id){
        return customerRepository.findById(id);
    }

    public void register(Customer customer){
        customerRepository.save(customer);
    }

    public boolean login(String username, String password){
        Customer customer = customerRepository.getByUsername(username);
        if(customer!=null && customer.checkCredentials(username, password)){
            System.out.println("Login succesful");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }
    }
}
