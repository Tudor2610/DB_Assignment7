package com.homework.db_assignment7.services;

import com.homework.db_assignment7.models.CustomerOrder;
import com.homework.db_assignment7.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    public CustomerOrder getById(Integer id){
        return customerOrderRepository.getById(id);
    }

    public List<CustomerOrder> getAll(){
        return customerOrderRepository.findAll();
    }

    public List<CustomerOrder> getAllByCustomerId(Integer id){
        return customerOrderRepository.getAllByCustomer_Id(id);
    }

    public void insert(CustomerOrder customerOrder){
        customerOrderRepository.save(customerOrder);
    }

    public void update(CustomerOrder customerOrder){
        customerOrderRepository.save(customerOrder);
    }

    public void delete(CustomerOrder customerOrder){
        customerOrderRepository.delete(customerOrder);
    }
}
