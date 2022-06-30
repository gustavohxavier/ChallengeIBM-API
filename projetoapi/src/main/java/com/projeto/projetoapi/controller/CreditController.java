package com.projeto.projetoapi.controller;

import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping
    public ResponseEntity<List<CreditModel>> getAllCredits(){
        return ResponseEntity.status(HttpStatus.OK).body(creditService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
        Optional<CreditModel> creditModelOptional = creditService.findById(id);
        if (!creditModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(creditModelOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCredit(@PathVariable(value = "id") Long id){
        Optional<CreditModel> creditModelOptional = creditService.findById(id);
        if (!creditModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found.");
        }
        creditService.delete(creditModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Credit deleted succesfully.");
    }
}
