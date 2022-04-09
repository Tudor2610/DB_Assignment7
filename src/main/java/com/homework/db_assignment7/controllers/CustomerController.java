package com.homework.db_assignment7.controllers;


import com.homework.db_assignment7.models.Customer;
import com.homework.db_assignment7.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//cookies implemented only here
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/id/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer){
        customerService.register(customer);
    }

    @PostMapping("/login/{username}/{password}")
    @ResponseBody
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password){
        if(customerService.login(username, password)) {
            ResponseCookie responseCookie = ResponseCookie.from(username, "1")
                    .httpOnly(true)
                    .secure(true)
                    .path("/")
                    .maxAge(7*24*60*60)
                    .build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).build();
        } else {
            return null;
        }
    }

    @GetMapping("/cookie")
    public String readCookie(@CookieValue(name = "abcdef", defaultValue = "1") String username){
        return username;
    }
}
