package com.fpt.apiservice.services;

import com.fpt.apiservice.models.Payment;
import com.fpt.apiservice.repositories.PaymentRepository;
import com.fpt.apiservice.requests.payment.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public ResponseEntity<List<Payment>> getPayments(Long userId) {
        return ResponseEntity.ok(paymentRepository.findByUserId(userId));
    }

    public ResponseEntity<Payment> getSinglePayment(Long id, Long userId) {
        Optional<Payment> paymentData = paymentRepository.findByIdAndUserId(id, userId);
        if(paymentData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Payment>(paymentData.get(), HttpStatus.OK);
    }

    public ResponseEntity<Payment> createPayment(PaymentRequest request, Long userId) {
        Payment data = Payment.builder()
                .name(request.name())
                .type(request.type())
                .balance(request.balance())
                .userId(userId)
                .build();

        return new ResponseEntity<Payment>(paymentRepository.save(data), HttpStatus.OK);
    }

    public ResponseEntity<Payment> updatePayment(
            Long paymentId,
            PaymentRequest request,
            Long userId
    ) {
        //find payment data
        Optional<Payment> data = paymentRepository.findById(paymentId);
        if(data.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(request.name() != null) { data.get().setName(request.name()); }
        if(request.type() != null) { data.get().setType(request.type()); }
        if(request.balance() != null) { data.get().setBalance(request.balance()); }

        return new ResponseEntity<Payment>(paymentRepository.save(data.get()), HttpStatus.OK);
    }

    public ResponseEntity deletePayment(Long paymentId) {
        Optional<Payment> data = paymentRepository.findById(paymentId);
        if(data.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentRepository.deleteById(paymentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
