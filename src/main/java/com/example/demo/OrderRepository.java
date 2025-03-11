package com.example.demo;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Order.class, idClass = Order.OrderId.class)
public interface OrderRepository {

    Order getById(Order.OrderId id);

    List<Order> findByCustomerId(Order.CustomerId customerId);

    Order save(Order order);

}
