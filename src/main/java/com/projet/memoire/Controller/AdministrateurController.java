package com.projet.memoire.Controller;

import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Administrateur;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Repository.AdministrateurRepository;
import com.projet.memoire.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdministrateurController {
    @Autowired
    private AdministrateurRepository administrateurRepository;


    @PostMapping
    public Administrateur CreateAdmin(@RequestBody Administrateur administrateur){
        return administrateurRepository.save(administrateur);
    }


    @GetMapping
    public List<Administrateur> getAllAdmin(){
        return administrateurRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Administrateur> getAdminById(@PathVariable long id){
        Administrateur administrateur= administrateurRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        return ResponseEntity.ok(administrateur);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Administrateur> updateAdmin(@PathVariable long id , @RequestBody Administrateur AdminDetails){
        Administrateur updateadmin= administrateurRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        updateadmin.setNom(AdminDetails.getNom());
        updateadmin.setPrenom(AdminDetails.getPrenom());
        updateadmin.setAge(AdminDetails.getAge());
        updateadmin.setTelephone(AdminDetails.getTelephone());
        updateadmin.setEmailId(AdminDetails.getEmailId());
        updateadmin.setAdresse(AdminDetails.getAdresse());


        administrateurRepository.save(updateadmin);
        return ResponseEntity.ok(updateadmin);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable long id){
        Administrateur administrateur= administrateurRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with" +id));
        administrateurRepository.delete(administrateur);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
