package com.joc.mstracing.customer.bootstrap;

import com.joc.mstracing.customer.domain.Customer;
import com.joc.mstracing.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by o'connell on 9/19/17.
 */
@Component
public class JpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadCustomers();
    }

    public void loadCustomers(){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        customer1.setName("Test1 Name1");
        customer1.setEmail("test1@email.com");
        customerService.saveOrUpdate(customer1);

        customer2.setName("Test2 Name2");
        customer2.setEmail("test2@email.com");
        customerService.saveOrUpdate(customer2);

        customer3.setName("Test3 Name3");
        customer3.setEmail("test3@email.com");
        customerService.saveOrUpdate(customer3);

    }
}
