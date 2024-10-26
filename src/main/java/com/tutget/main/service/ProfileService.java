package com.tutget.main.service;

import com.tutget.main.model.Profile;
import com.tutget.main.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class ProfileService {

    @Bean
    public static PasswordEncoder getPassowrdEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    public  List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfile(String id) {
        return profileRepository.findById(id);
    }

    public Profile login(Profile loginProfile) {
////        ProfileList profileList = new ProfileList();
//        List<Profile> profiles = new ArrayList<>();
//        profileRepository.findByUserID(userID).forEach(profiles::add);
//        profileList.setProfileList(profiles);
//        return profileList;
        Profile profile = null;
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findByUserID(loginProfile.getUserID()).forEach(profiles::add);
        if(profiles.size()>0){
            profile = profiles.get(0);
        }
        if (profile!=null && passwordEncoder.matches(loginProfile.getPassword(),profile.getPassword())){
            profile.setAuthenticateStatus(true);
            return profile;
        }
        else{
            return loginProfile;
        }
//        profileList.setProfileList(profiles);

        //return loginProfile;
    }

    public Profile getProfileByUserID(String userID) {
////        ProfileList profileList = new ProfileList();
//        List<Profile> profiles = new ArrayList<>();
//        profileRepository.findByUserID(userID).forEach(profiles::add);
//        profileList.setProfileList(profiles);
//        return profileList;

        Profile profile = new Profile();
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findByUserID(userID).forEach(profiles::add);
        if(profiles.size()>0){
            profile = profiles.get(0);
        }

//        profileList.setProfileList(profiles);
        return profile;
    }

    public Profile addProfile(Profile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profileRepository.save(profile);
        return profile;
    }

    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void deleteProfile(String id) {
        profileRepository.deleteById(id);
    }

    public List<Profile> getProfileListByDescription(String description) {
        return profileRepository.findByDescriptionContainingIgnoreCase(description);
    }


    public List<Profile> getProfileListByName(String name) {
//        profileRepository.findByFirstName(name).forEach(profiles::add);
//        profileRepository.findByLastName(name).forEach(profiles::add);
        return profileRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

}
