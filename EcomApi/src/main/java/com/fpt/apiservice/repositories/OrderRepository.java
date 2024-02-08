package com.fpt.apiservice.repositories;

import com.fpt.apiservice.models.Orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByCreatedByOrderByUpdatedDateDesc(Long createdBy);
    List<Order> findByStatusInAndCreatedByOrderByUpdatedDateDesc(List<String> status, Long createdBy);
}