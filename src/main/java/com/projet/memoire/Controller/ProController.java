package com.projet.memoire.Controller;

import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Profile;
import com.projet.memoire.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profile")

public class ProController {
    @Autowired
    private ProfileRepository profileRepository;


    @PostMapping
    public Profile Createprofile(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }


    @GetMapping
    public List<Profile> getAllProfile(){
        return profileRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable long id){
        Profile profile= profileRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        return ResponseEntity.ok(profile);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Profile> updateprofile(@PathVariable long id , @RequestBody Profile profileDetails){
        Profile updateprofile= profileRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        updateprofile.setNom(profileDetails.getNom());



        profileRepository.save(updateprofile);
        return ResponseEntity.ok(updateprofile);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable long id){
        Profile profile= profileRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with" +id));
        profileRepository.delete(profile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


