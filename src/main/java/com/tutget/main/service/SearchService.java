package com.tutget.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutget.main.model.Listing;
import com.tutget.main.repository.ListingRepository;

@Service
public class SearchService {

    @Autowired
    private ListingRepository listingRepository;

    public Optional<Listing> searchId(String id) {
        return listingRepository.findById(id);
    }

    public List<Listing> searchAll(String searchKey) {
        return listingRepository.findByDescription(searchKey);
    }

    // public AllListing searchAllAll(Object requestData) {
    //     ResponseEntity<AllListing> listingResp =  restTemplate.exchange(listingmicroserviceURL + "/find/all/"+ requestData , HttpMethod.GET, null, AllListing.class,requestData);
    //     //ResponseEntity<Listing> listingResp =  restTemplate.exchange(discoveryClient.getNextServerFromEureka("listing-service", false).getHomePageUrl() +"listings/" + id , HttpMethod.GET, null, Listing.class,id);
    //     AllListing listings = listingResp.getBody();

    //     if (requestData != null) { 
    //         return (listings);
    //     } else {
    //         System.out.println("No results");
    //         return null; 
    //     }
    // }
        // List<SearchResult> results = new ArrayList<>();

        // Perform a search on the listing microservice
        // List<ListingResult> listingResults = listingService.searchInListingMicroservice(query);
        // results.addAll(listingResults);

        // Perform a search on the Q&A microservice
        // List<QnaResult> qnaResults = qnaService.searchInQnaMicroservice(query);
        // results.addAll(qnaResults);
}