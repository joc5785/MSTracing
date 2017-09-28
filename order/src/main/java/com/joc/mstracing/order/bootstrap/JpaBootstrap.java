package com.joc.mstracing.order.bootstrap;

import com.joc.mstracing.order.domain.Customer;
import com.joc.mstracing.order.domain.Orders;
import com.joc.mstracing.order.domain.Product;
import com.joc.mstracing.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by o'connell on 9/19/17.
 */

@Component
public class JpaBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadOrders();
    }

    public void loadOrders(){
        Product product1 = new Product();
        Customer customer1 = new Customer();
        Orders order1 = new Orders();

        Product product2 = new Product();
        Customer customer2 = new Customer();
        Orders order2 = new Orders();

        Product product3 = new Product();
        Customer customer3 = new Customer();
        Orders order3 = new Orders();

        //-------------------
        product1.setId(1);
        product1.setSku("abc124");
        product1.setDescription("TEST TEST TEST");

        customer1.setId(1);
        customer1.setEmail("email@test.com");
        customer1.setName("Test Name");

        order1.setAmount(15);
        order1.setOrderDate(new Date());
        order1.setCustomerId(1);
        order1.setProductId(1235);
        orderService.saveOrUpdate(order1);
        //-------------------
        product2.setId(2);
        product2.setSku("abc124");
        product2.setDescription("TEST TEST TEST");

        customer2.setId(2);
        customer2.setEmail("email2@test.com");
        customer2.setName("Test Name");

        order2.setAmount(25);
        order2.setOrderDate(new Date());
        order2.setCustomerId(2);
        order2.setProductId(2222);
        orderService.saveOrUpdate(order2);
        //----------------------
        product3.setId(3);
        product3.setSku("abc333");
        product3.setDescription("TEST3 TEST3 TEST3");

        customer3.setId(3);
        customer3.setEmail("email3@test.com");
        customer3.setName("Test Name");

        order3.setAmount(35);
        order3.setOrderDate(new Date());
        order3.setCustomerId(4);
        order3.setProductId(3333);
        orderService.saveOrUpdate(order3);
    }
}
