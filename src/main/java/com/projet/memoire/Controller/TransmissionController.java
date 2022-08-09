package com.projet.memoire.Controller;

import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Service;
import com.projet.memoire.Models.Transmission;
import com.projet.memoire.Repository.ServiceRepository;
import com.projet.memoire.Repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/canal")

public class TransmissionController {

    @Autowired
    private TransmissionRepository transmissionRepository;

    @PostMapping
    public Transmission Createcanal(@RequestBody Transmission transmission){
        return  transmissionRepository.save(transmission);
    }

    @GetMapping
    public List<Transmission> getAllCanal(){
        return transmissionRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Transmission> getCanalById(@PathVariable long id){
        Transmission transmission= transmissionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Transmission not exist with id" +id));
        return ResponseEntity.ok(transmission);
    }

    @PutMapping("{id}")

    public  ResponseEntity<Transmission> updateCanal(@PathVariable long id , @RequestBody Transmission CanalDetails){
        Transmission updateTransmission= transmissionRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("transmission not exist with id" +id));
        updateTransmission.setLibcanal(CanalDetails.getLibcanal());
        updateTransmission.setReference(CanalDetails.getReference());
        transmissionRepository.save(updateTransmission);
        return ResponseEntity.ok(updateTransmission);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCanal(@PathVariable long id){
        Transmission transmission= transmissionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("transmission not exist with" +id));
        transmissionRepository.delete(transmission);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
