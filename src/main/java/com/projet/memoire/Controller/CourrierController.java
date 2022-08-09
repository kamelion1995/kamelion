package com.projet.memoire.Controller;


import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Models.Courrier;
import com.projet.memoire.Repository.CourrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Courrier")
public class CourrierController {


    @Autowired
    private CourrierRepository courrierRepository;

    @PostMapping
    public Courrier CreateAgent(@RequestBody Courrier courrier){
        return  courrierRepository.save(courrier);
    }

    @GetMapping
    public List<Courrier> getAllAgent(){
        return courrierRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Courrier> getCourrierById(@PathVariable long id){
        Courrier courrier= courrierRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("courrier not exist with id" +id));
        return ResponseEntity.ok(courrier);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Courrier> updateCourrier(@PathVariable long id , @RequestBody Courrier CourrierDetails){
        Courrier updateCourier= courrierRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("courier not exist with id" +id));
        updateCourier.setDate(CourrierDetails.getDate());
        updateCourier.setObjet(CourrierDetails.getObjet());
        updateCourier.setDetails(CourrierDetails.getDetails());
        updateCourier.setEtat(CourrierDetails.isEtat());
        courrierRepository.save(updateCourier);
        return ResponseEntity.ok(updateCourier);


    }
    @DeleteMapping("{id}")

    public ResponseEntity<HttpStatus> deleteCourrier(@PathVariable long id){
        Courrier courrier= courrierRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("courrier not exist with" +id));
        courrierRepository.delete(courrier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
