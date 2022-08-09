package com.projet.memoire.Controller;


import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Administrateur;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Repository.AgentRepository;
import com.projet.memoire.Service.AdminService;
import com.projet.memoire.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/agent")
@RestController
public class AgentController {


    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AdminService adminService;


    @PostMapping
    public Agent CreateAgent(@RequestBody  Agent agent){
        return agentRepository.save(agent);
    }


    @GetMapping
    public List<Agent> getAllAgent(){
        return agentRepository.findAll();
    }

    @PostMapping("/loginagent")
    public Agent login(@RequestBody Agent agent) throws Exception {
        String tmpEmail= agent.getEmailId();
        String tmpass= agent.getPassword();
        Agent proObj= null;
        if(tmpEmail !=null && tmpass !=null){
            proObj= agentService.fetchAgentByEmailidAndPassword(tmpEmail,tmpass);
        }
        if(proObj == null){
            throw new Exception("Bad Credentials");
        }
        return proObj;

    }
    @PostMapping("/loginadmint")
    public Administrateur Admin(@RequestBody Administrateur administrateur) throws Exception {
        String tmpEmail= administrateur.getEmailId();
        String tmpass= administrateur.getPassword();
        Administrateur proObj= null;
        if(tmpEmail !=null && tmpass !=null){
            proObj= adminService.fetchAgentByEmailidAndPassword(tmpEmail,tmpass);
        }
        if(proObj == null){
            throw new Exception("Bad Credentials");
        }
        return proObj;

    }

    @GetMapping("{id}")
        public ResponseEntity<Agent> getAgentById(@PathVariable long id){
            Agent personne= agentRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
            return ResponseEntity.ok(personne);
        }

    @PutMapping("{id}")
    public  ResponseEntity<Agent> updateAgent(@PathVariable long id , @RequestBody Agent AgentDetails){
        Agent updatePersonne= agentRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("personne not exist with id" +id));
        updatePersonne.setNom(AgentDetails.getNom());
        updatePersonne.setPrenom(AgentDetails.getPrenom());
        updatePersonne.setAge(AgentDetails.getAge());
        updatePersonne.setTelephone(AgentDetails.getTelephone());
        updatePersonne.setTelephone1(AgentDetails.getTelephone1());
        updatePersonne.setEmailId(AgentDetails.getEmailId());
        updatePersonne.setAdresse(AgentDetails.getAdresse());
        updatePersonne.setMatricule((AgentDetails.getMatricule()));
        updatePersonne.setUsername((AgentDetails.getUsername()));
        updatePersonne.setMatricule((AgentDetails.getMatricule()));


        agentRepository.save(updatePersonne);
        return ResponseEntity.ok(updatePersonne);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePersonne(@PathVariable long id){
        Agent personne= agentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("personne not exist with" +id));
        agentRepository.delete(personne);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
