package com.projeto.projetoapi.controllers;

import com.projeto.projetoapi.dtos.requests.ContractRequest;
import com.projeto.projetoapi.dtos.responses.ContractResponse;
import com.projeto.projetoapi.entities.ContractEntity;
import com.projeto.projetoapi.services.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/contracts")
@Api(value = "API REST Contratos de Comercialização")
@CrossOrigin(origins = "*")
public class ContractController {

    @Autowired
    private ContractService contractService;

    //Retorna uma tupla do DB especificada por ID
    @GetMapping
    @ApiOperation(value = "Retorna contratos definidos por parâmetros")
    public ResponseEntity<List<ContractResponse>> getByParam(ContractRequest contractRequest){
        List<ContractResponse> contractResponse = contractService.findByParam(contractRequest);
        return ResponseEntity.status(HttpStatus.OK).body(contractResponse);
    }

    @GetMapping(value = "/page")
    @ApiOperation(value = "Retorna os contratos paginados")
    public ResponseEntity<Page<ContractEntity>> findAll(Pageable pageable){
        Page<ContractEntity> creditModelPage = contractService.findAllPageable(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(creditModelPage);
    }

    //Deleta uma tupla do DB especificada por ID
    @DeleteMapping
    @ApiOperation(value = "Deleta um contrato especificado por ID")
    public ResponseEntity<String> deleteCredit(@RequestParam Long id){
        contractService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Credit deleted succesfully.");
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza contrato especificado por ID")
    public ResponseEntity<ContractResponse> updateCredit(@PathVariable(value = "id") Long id,
                                                         @RequestBody ContractRequest contractRequest){

        ContractResponse contractResponse = contractService.save(contractRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(contractResponse);
    }

    @GetMapping(value = "/year/{year}")
    @ApiOperation(value = "Retorna a sumYear dos valores de custeio dos contrato especificados por ano")
    public ResponseEntity<Object> getByYear(@PathVariable(value = "year") String year){
        return ResponseEntity.status(HttpStatus.OK).body(contractService.findByYear(year));
    }

    @PostMapping
    @ApiOperation(value = "Insere um novo contrato")
    public ResponseEntity<ContractResponse> createCredit(@RequestBody ContractRequest contractRequest){
        ContractResponse contractResponse = contractService.save(contractRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contractResponse);
    }
}
