package com.joc.mstracing.customer.controllers;


import com.joc.mstracing.customer.domain.Customer;
import com.joc.mstracing.customer.service.CustomerService;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by o'connell on 9/19/17.
 */

@RequestMapping("/customer")
@RestController
public class CustomerController {
    private CustomerService customerService;
    private ResponseEntity<String> response;
    private RestTemplate restTemplate;
    private io.opentracing.Tracer tracer;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @Autowired
    public void setTracer(Tracer tracer){
        this.tracer = tracer;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/list")
    public List<Customer> listCustomers()
    {
        return customerService.listAll();
    }

    @RequestMapping("/show/{id}")
    public Customer showCustomer(@PathVariable Integer id) throws InterruptedException {
        Thread.sleep(1 + (long)(Math.random()*500));
        String testURL = "http://date.jsontest.com";
        response = restTemplate.getForEntity(testURL, String.class);
        System.out.print(response);
        return (Customer) customerService.getById(id);
    }

}
