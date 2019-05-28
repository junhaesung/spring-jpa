package com.nhn.edu.jpa.repository;

import com.nhn.edu.jpa.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph("orderWithCustomer")
    List<Order> getAllBy();

    @EntityGraph("orderWithOrderItems")
    List<Order> readAllBy();

    @EntityGraph("orderWithCustomerAndOrderItems")
    List<Order> queryAllBy();

    @EntityGraph("orderWithCustomerAndOrderItemsAndItem")
    List<Order> findAllBy();

}
