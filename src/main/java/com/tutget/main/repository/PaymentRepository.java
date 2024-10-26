package com.tutget.main.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.tutget.main.model.Payment;

public interface PaymentRepository extends ListCrudRepository<Payment, String> {

}