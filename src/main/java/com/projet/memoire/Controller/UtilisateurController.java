package com.projet.memoire.Controller;

import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Models.Utilisateur;
import com.projet.memoire.Repository.AgentRepository;
import com.projet.memoire.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")

public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @PostMapping
    public Utilisateur CreateUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }


    @GetMapping
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable long id){
        Utilisateur utilisateur= utilisateurRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        return ResponseEntity.ok(utilisateur);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable long id , @RequestBody Utilisateur utilisateurDetails){
        Utilisateur updateutilisateur= utilisateurRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        updateutilisateur.setUsername(utilisateurDetails.getUsername());
        updateutilisateur.setPassword(utilisateurDetails.getPassword());


        utilisateurRepository.save(updateutilisateur);
        return ResponseEntity.ok(updateutilisateur);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable long id){
        Utilisateur utilisateur= utilisateurRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with" +id));
        utilisateurRepository.delete(utilisateur);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
