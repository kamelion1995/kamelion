package com.projet.memoire.Controller;


import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Courrier;
import com.projet.memoire.Models.Service;
import com.projet.memoire.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public Service CreateService(@RequestBody Service service){
        return  serviceRepository.save(service);
    }

    @GetMapping
    public List<Service> getAllService(){
        return serviceRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable long id){
        Service service= serviceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Service not exist with id" +id));
        return ResponseEntity.ok(service);
    }

    @PutMapping("{id}")

    public  ResponseEntity<Service> updateService(@PathVariable long id , @RequestBody Service ServiceDetails){
        Service updateService= serviceRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("service not exist with id" +id));
        updateService.setNomService(ServiceDetails.getNomService());
        updateService.setResponsable(ServiceDetails.getResponsable());
        updateService.setTelService(ServiceDetails.getTelService());
        updateService.setEmailService(ServiceDetails.getEmailService());
        serviceRepository.save(updateService);
        return ResponseEntity.ok(updateService);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable long id){
        Service service= serviceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("service not exist with" +id));
        serviceRepository.delete(service);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
