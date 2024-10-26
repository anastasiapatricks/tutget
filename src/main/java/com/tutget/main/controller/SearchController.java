package com.tutget.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutget.main.model.Listing;
import com.tutget.main.service.SearchService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;
    
    // @GetMapping("/all/all/{requestData}")    
    // public List<Listing> getSearchResultAll(@PathVariable("requestData") Object requestData){
    //     return searchService.searchAllAll(requestData);
    // }

    @GetMapping("/all/{searchKey}")    
    public List<Listing> getSearchResult(@PathVariable("searchKey") String searchKey){
        return searchService.searchAll(searchKey);
    }

    @GetMapping("/{id}")    
    public Listing getListing(@PathVariable("id") String id){
        Optional<Listing> o = searchService.searchId(id);
        if (o.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return o.get();
    }
}
