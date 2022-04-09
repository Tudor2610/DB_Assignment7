package com.homework.db_assignment7.repositories;

import com.homework.db_assignment7.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
    public List<CustomerOrder> getAllByCustomer_Id(Integer id);
}
