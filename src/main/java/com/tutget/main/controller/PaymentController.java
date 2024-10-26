package com.tutget.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutget.main.model.Listing;
import com.tutget.main.model.Payment;
import com.tutget.main.service.ListingService;
import com.tutget.main.service.PaymentService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class PaymentController {
     
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ListingService listingService;

    @RequestMapping("/payment/{id}")
    public Listing getListingDetails(@PathVariable String id){
        Optional<Listing> o = listingService.getListing(id);
        if (o.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return o.get();
    }

    @PutMapping("/payment")
    public void updateListing(@RequestBody Listing listing){
        listingService.updateListing(listing);
    }

    @PostMapping("/payment/addPayment")
    public String addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
}
