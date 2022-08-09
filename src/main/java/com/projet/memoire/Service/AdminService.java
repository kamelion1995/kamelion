package com.projet.memoire.Service;

import com.projet.memoire.Models.Administrateur;
import com.projet.memoire.Models.Agent;
import com.projet.memoire.Repository.AdministrateurRepository;
import com.projet.memoire.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public Administrateur saveAdministrateur(Administrateur administrateur){
        return   administrateurRepository.save(administrateur);
    }

    public  Administrateur fetchAgentByEmailid(String email){
        return administrateurRepository.findByEmailId(email);
    }

    public Administrateur fetchAgentByEmailidAndPassword(String email, String password){
        return administrateurRepository.findByEmailIdAndPassword(email,password);
    }
}
