package com.tutget.main.service;

import com.tutget.main.model.Listing;
import com.tutget.main.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public  List<Listing> getAllListings(){
        return listingRepository.findAll();
    }

    public Optional<Listing> getListing(String id){
        return listingRepository.findById(id);
    }

    public String addListing(Listing listing) {
        listingRepository.save(listing);
        return listing.getId();
    }

    public void updateListing(Listing listing) {
        listingRepository.save(listing);
    }

    public void deleteListing(String id) {
        listingRepository.deleteById(id);
    }

    public List<Listing> getAllListingsByDescription(String description){
        return listingRepository.findByDescription(description);

    }

    public List<Listing> getSearchListings(String searchKey) {
        if(searchKey == null){
            return listingRepository.findAll();
        }
        else{
            return listingRepository.findByIdContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchKey,searchKey);
        }
    }

    // public AllListing getSearchListingsAll(Object requestData) {
    //     // AllListing allListing = new AllListing();
    //     // List<Listing> listings = new ArrayList<>();     
    //     // System.out.println("ITS IS WITHIN THE FUNCTION getSearchListingsAll");

    //     for (Listing listing : requestData.getListings()) {
    //         if (listing == null) {
    //             allNotNull = false;
    //             break;
    //         }
    //     }
        

        
    //     if(requestData == null){
    //         listingRepository.findAll().forEach(listings::add);
    //         allListing.setAllListing(listings);
    //         return allListing;
    //     }
    //     else{
    //         listingRepository.findByIdContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchKey,searchKey).forEach(listings::add);
    //         System.out.println("Listings : " + listings.toString());
    //         allListing.setAllListing(listings);  
    //         return allListing;
    //     }
    // }

}
