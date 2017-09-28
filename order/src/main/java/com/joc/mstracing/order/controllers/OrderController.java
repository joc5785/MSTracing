package com.joc.mstracing.order.controllers;

import com.joc.mstracing.order.domain.Customer;
import com.joc.mstracing.order.domain.Orders;
import com.joc.mstracing.order.domain.Product;
import com.joc.mstracing.order.services.OrderService;
import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format.Builtin;
import io.opentracing.propagation.TextMapExtractAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by o'connell on 9/18/17.
 */

@RequestMapping("/order")
@RestController
public class OrderController {
    private OrderService orderService;
    private RestTemplate restTemplate;
    private ResponseEntity<Customer> customerResponse;
    private io.opentracing.Tracer tracer;

    @Autowired
    public void setTracer(Tracer tracer){
        this.tracer = tracer;
    }

    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService = orderService;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    @RequestMapping("/list")
    public List<Orders> listOrders(){
        return orderService.listAll();
    }

    @RequestMapping("/show/{id}")
    public Map<String, Object> showOrder(@PathVariable Integer id, @RequestHeader Map<String, String> request){
        Map<String, Object> map = new HashMap<>();
        Orders tempOrder = (Orders) orderService.getById(id);
//        String productURL = "http://localhost:8082/product/show/"+tempOrder.getProductId();
//        ResponseEntity<Product> productResponse = restTemplate.getForEntity(productURL + "/1", Product.class);
//        Map<String, String> headers = request;
//        SpanContext parentSpan = tracer.extract(Builtin.HTTP_HEADERS, new TextMapExtractAdapter(headers));
//        SpanContext span = tracer.a
//        tracer.inject(SpanContext);

        String customerURL = "http://localhost:8083/customer/show/" + tempOrder.getCustomerId();
        System.out.println(customerURL);
        customerResponse = restTemplate.getForEntity(customerURL, Customer.class);

        map.put("Order", tempOrder);
        map.put("Customer", customerResponse);
       // map.put("Product", productResponse);
        return map;
    }

}
