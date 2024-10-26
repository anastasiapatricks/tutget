package com.tutget.main.controller;

import com.tutget.main.model.Profile;
import com.tutget.main.service.ProfileService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/users")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/users/{id}")
    public Profile getProfile(@PathVariable String id){
        Optional<Profile> o = profileService.getProfile(id);
        if (o.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return o.get();
    }

    @PostMapping("/users/login")
    public Profile loginUser(@RequestBody Profile profile){
        return profileService.login(profile);
    }

    @GetMapping("/users/userId/{userID}")
    public Profile getProfileByUserID(@PathVariable String userID){
        return profileService.getProfileByUserID(userID);
    }

    @PostMapping("/users")
    public Profile addUser(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody Profile profile){
        profileService.updateProfile(profile);
    }
    @DeleteMapping("/users/{id}")
    public void deleteListing(@PathVariable String id){
        profileService.deleteProfile(id);
    }

    @GetMapping("/users/findByDescription/{desciption}")
    public List<Profile> getProfilesByDescription(@PathVariable String description){
        return profileService.getProfileListByDescription(description);
    }

    @GetMapping("/users/findByName/{name}")
    public List<Profile> getProfileByName(@PathVariable String name){
        return profileService.getProfileListByName(name);
    }
}