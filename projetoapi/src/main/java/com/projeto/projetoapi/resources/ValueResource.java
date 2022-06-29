package com.projeto.projetoapi.resources;

import com.projeto.projetoapi.entities.Value;
//import com.projeto.projetoapi.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/values")
public class ValueResource {

    /*@Autowired
    private ValueRepository valueRepository;*/

    /*@GetMapping
    public ResponseEntity<List<Value>> findAll(){
        //TODO
        *//*List<Value> list = valueRepository.findAll();
        return ResponseEntity.ok().body(list);*//*
    }*/

    //Consultar produtos por ID
    /*@GetMapping(value = "/{id}")
    public ResponseEntity<Value> findById(@PathVariable Long id){
        //TODO
        *//*Value cat = valueRepository.findById(id).get();
        return ResponseEntity.ok().body(cat);*//*
    }*/
}
