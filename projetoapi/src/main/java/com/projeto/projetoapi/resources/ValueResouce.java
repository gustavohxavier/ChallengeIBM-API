package com.projeto.projetoapi.resources;

import com.projeto.projetoapi.entities.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/values")
public class ValueResouce {

    @GetMapping
    public ResponseEntity<List<Value>> findAll(){
        //TODO
    }

    //Consultar produtos por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Value> findById(@PathVariable Long id){
        //TODO
    }
}
