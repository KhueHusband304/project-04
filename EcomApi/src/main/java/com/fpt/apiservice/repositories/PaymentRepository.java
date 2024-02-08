package com.fpt.apiservice.repositories;

import com.fpt.apiservice.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);

    Optional<Payment> findByIdAndUserId(Long id, Long userId);
}
