package com.projet.memoire.Controller;


import com.projet.memoire.Exception.ResourceNotFoundException;
import com.projet.memoire.Models.Service;
import com.projet.memoire.Models.Type;
import com.projet.memoire.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/type")

public class TypeController  {

    @Autowired
    private TypeRepository typeRepository;

    @PostMapping
    public Type Createtype(@RequestBody Type type){
        return  typeRepository.save(type);
    }

    @GetMapping
    public List<Type> getAllType(){
        return typeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable long id){
        Type type= typeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Type not exist with id" +id));
        return ResponseEntity.ok(type);
    }

    @PutMapping("{id}")

    public  ResponseEntity<Type> updateType(@PathVariable long id , @RequestBody Type TypeDetails){
        Type updateType= typeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("type not exist with id" +id));
        updateType.setType(TypeDetails.getType());

        typeRepository.save(updateType);
        return ResponseEntity.ok(updateType);


    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteType(@PathVariable long id){
        Type type= typeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("type not exist with" +id));
        typeRepository.delete(type);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
