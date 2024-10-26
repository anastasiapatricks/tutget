package com.tutget.main.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.tutget.main.model.Profile;

import java.util.List;

public interface ProfileRepository extends ListCrudRepository<Profile, String> {

    public List<Profile> findByDescription(String description);

    public List<Profile> findByFirstName(String firstName);

    public List<Profile> findByLastName(String lastName);

    public List<Profile> findByUserID(String userID);

    public List<Profile> findByDescriptionContainingIgnoreCase(String description);

    public List<Profile> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String SecondName);

}
