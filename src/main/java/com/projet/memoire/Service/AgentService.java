package com.projet.memoire.Service;

import com.projet.memoire.Models.Agent;
import com.projet.memoire.Models.Provenance;
import com.projet.memoire.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent saveAgent(Agent agent){
       return   agentRepository.save(agent);
    }
    public  Agent fetchAgentByEmailid(String email){
        return agentRepository.findByEmailId(email);
    }
    public Agent fetchAgentByEmailidAndPassword(String email, String password){
        return agentRepository.findByEmailIdAndPassword(email,password);
    }
}
