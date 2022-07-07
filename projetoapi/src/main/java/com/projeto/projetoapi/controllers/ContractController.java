package com.projeto.projetoapi.controllers;

import com.projeto.projetoapi.dtos.requests.ContractRequest;
import com.projeto.projetoapi.dtos.responses.ContractResponse;
import com.projeto.projetoapi.entities.ContractEntity;
import com.projeto.projetoapi.services.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/credits")
public class ContractController {

    @Autowired
    private ContractService contractService;

    //Retorna uma tupla do DB especificada por ID
    @GetMapping
    public ResponseEntity<List<ContractResponse>> getByParam(ContractRequest contractRequest){
        List<ContractResponse> contractResponse = contractService.findByParam(contractRequest);
        return ResponseEntity.status(HttpStatus.OK).body(contractResponse);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ContractEntity>> findAll(Pageable pageable){
        Page<ContractEntity> creditModelPage = contractService.findAllPageable(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(creditModelPage);
    }

    //Deleta uma tupla do DB especificada por ID
    @DeleteMapping(value = "id")
    public ResponseEntity<String> deleteCredit(@RequestParam(value = "id") Long id){
        contractService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Credit deleted succesfully.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContractResponse> updateCredit(@PathVariable(value = "id") Long id,
                                                         @RequestBody ContractRequest contractRequest){

        ContractResponse contractResponse = contractService.save(contractRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(contractResponse);
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<Object> getByYear(@PathVariable(value = "year") String year){
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findByYear(year));
    }

    @PostMapping
    public ResponseEntity<ContractResponse> createCredit(@RequestBody ContractRequest contractRequest){

        ContractResponse contractResponse = contractService.save(contractRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contractResponse);
    }
}
