package com.projeto.projetoapi.controller;

import com.projeto.projetoapi.DTO.requests.CreditPUTByIdRequest;
import com.projeto.projetoapi.DTO.responses.CreditResponse;
import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //Retorna todos os dados do DB
    @GetMapping
    public ResponseEntity<List<CreditResponse>> getAllCredits(){
        return ResponseEntity.status(HttpStatus.OK).body(creditService.findAll());
    }

    //Retorna uma tupla do DB especificada por ID
    @GetMapping(value = "/id")
    public ResponseEntity<Object> getById(@RequestParam(value = "id") Long id){
        Optional<CreditModel> creditModelOptional = creditService.findById(id);
        if (creditModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found. Try again.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(creditModelOptional.get());
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CreditModel>> findAll(Pageable pageable){
        Page<CreditModel> creditModelPage = creditService.findAllPageable(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(creditModelPage);
    }

    //Deleta uma tupla do DB especificada por ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCredit(@PathVariable(value = "id") Long id){
        Optional<CreditModel> creditModelOptional = creditService.findById(id);
        if (creditModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found. Try again.");
        }
        creditService.delete(creditModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Credit deleted succesfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCredit(@PathVariable(value = "id") Long id,
                                               @RequestBody CreditPUTByIdRequest creditPUTByIdRequest){

        Optional<CreditModel> creditModelOptional = creditService.findById(id);
        if(creditModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found. Try again.");
        }
        CreditResponse creditResponse = creditService.save(creditPUTByIdRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(creditResponse);
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<Object> getByYear(@PathVariable(value = "year") String year){
        List<CreditModel> creditModelList1 = creditService.findByYear(year);
        if (creditModelList1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credit not found. Try again.");
        }
        List<CreditModel> creditModelList = creditService.findByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(creditModelList);
    }

    //@PostMapping
}
