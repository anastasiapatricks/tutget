package com.tutget.main.repository;

import com.tutget.main.model.Listing;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ListingRepository extends ListCrudRepository<Listing, String> {

    public List<Listing> findByDescription(String description);

    public List<Listing> findByIdContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String key1, String key2);

    //public List<Listing> findByIdContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String key1, String key2);

}
