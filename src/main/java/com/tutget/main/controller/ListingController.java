package com.tutget.main.controller;

import com.tutget.main.model.Listing;
import com.tutget.main.service.ListingService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @RequestMapping("/listings")
    public List<Listing> getAllListings(){
        return listingService.getAllListings();
    }

    @RequestMapping("/listings/{id}")
    public Listing getListing(@PathVariable String id){
        Optional<Listing> o = listingService.getListing(id);
        if (o.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return o.get();
    }

    @PostMapping("/listings")
    public String addListing(@RequestBody Listing listing){
        return listingService.addListing(listing);
    }

    @PutMapping("/listings")
    public void updateListing(@RequestBody Listing listing){
        listingService.updateListing(listing);
    }
    @DeleteMapping("/listings/{id}")
    public void deleteListing(@PathVariable String id){
        listingService.deleteListing(id);
    }
    @RequestMapping("/listings/find/{description}")
    public List<Listing> getListingsByDescription(@PathVariable String description){
        return listingService.getAllListingsByDescription(description);
    }
}
