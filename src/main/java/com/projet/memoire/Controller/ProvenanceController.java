package com.projet.memoire.Controller;

import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Administrateur;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Models.Provenance;
import com.projet.memoire.Repository.AgentRepository;
import com.projet.memoire.Repository.ProvenanceRepository;
import com.projet.memoire.Service.AdminService;
import com.projet.memoire.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/provenance")

public class ProvenanceController {

    @Autowired
    private ProvenanceRepository provenanceRepository;





    @PostMapping
    public Provenance CreateProvenance(@RequestBody Provenance provenance){
        return provenanceRepository.save(provenance);
    }


    @GetMapping
    public List<Provenance> getAllProvenance(){
        return provenanceRepository.findAll();
    }



    @GetMapping("{id}")
    public ResponseEntity<Provenance> getProvenanceById(@PathVariable long id){
        Provenance personne= provenanceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("provenance not exist with id" +id));
        return ResponseEntity.ok(personne);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Provenance> updateProvenance(@PathVariable long id , @RequestBody Provenance ProvenanceDetails){
        Provenance updateProvenance= provenanceRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("provenance not exist with id" +id));
        updateProvenance.setType(ProvenanceDetails.getType());
        updateProvenance.setTelephone(ProvenanceDetails.getTelephone());
        updateProvenance.setEmailId(ProvenanceDetails.getEmailId());
        updateProvenance.setAdresse(ProvenanceDetails.getAdresse());
        updateProvenance.setNom(ProvenanceDetails.getNom());
        updateProvenance.setPassword(ProvenanceDetails.getPassword());



        provenanceRepository.save(updateProvenance);
        return ResponseEntity.ok(updateProvenance);


    }



    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProvenance(@PathVariable long id){
        Provenance personne= provenanceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("provenance not exist with" +id));
        provenanceRepository.delete(personne);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
