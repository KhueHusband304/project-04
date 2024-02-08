package com.fpt.apiservice.controller.client;

import com.fpt.apiservice.models.Payment;
import com.fpt.apiservice.requests.payment.PaymentRequest;
import com.fpt.apiservice.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/payment")
public record PaymentController(PaymentService paymentService) {

    //get all payment
    @GetMapping
    public ResponseEntity<List<Payment>> getProducts(@RequestAttribute Long userId) {
        return paymentService.getPayments(userId);
    }

    //get single payment
    @GetMapping(path = "{paymentId}")
    public ResponseEntity<Payment> getSinglePayment(
            @PathVariable("paymentId") Long id,
            @RequestAttribute Long userId
    ) {
        return paymentService.getSinglePayment(id, userId);
    }

    //create payment
    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestBody PaymentRequest paymentRequest,
            @RequestAttribute Long userId
    ) {
        return paymentService.createPayment(paymentRequest, userId);
    }

    //update payment
    @PutMapping(path = "{paymentId}")
    public ResponseEntity<Payment> updateProduct(
            @PathVariable("paymentId") Long id,
            @RequestBody PaymentRequest paymentRequest,
            @RequestAttribute Long userId
    ) {
        return paymentService.updatePayment(id, paymentRequest, userId);
    }

    //delete payment
    @DeleteMapping(path = "{paymentId}")
    public ResponseEntity deletePayment(@PathVariable("paymentId") Long id) {
        return paymentService.deletePayment(id);
    }
}
