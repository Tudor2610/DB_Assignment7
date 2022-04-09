package com.homework.db_assignment7.models;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private Date orderDate;
    private Date shippedDate;
    private String status;
    private String comments;
    @ManyToOne
    private Customer customer;
}
