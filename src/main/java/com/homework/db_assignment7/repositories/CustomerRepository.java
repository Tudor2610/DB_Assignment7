package com.homework.db_assignment7.repositories;

import com.homework.db_assignment7.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer getByUsername(String username);
    public Customer getByCity(String city);
}
