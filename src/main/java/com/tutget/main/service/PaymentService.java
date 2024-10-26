package com.tutget.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutget.main.model.Payment;
import com.tutget.main.repository.PaymentRepository;

@Service
public class PaymentService {
     
    @Autowired
    private PaymentRepository paymentRepository;

    public String addPayment(Payment payment) {
        paymentRepository.save(payment);
        return payment.getTransactionId();
    }

    public Optional<Payment> getPayment(String transactionId) {
        return paymentRepository.findById(transactionId);
    }
}
