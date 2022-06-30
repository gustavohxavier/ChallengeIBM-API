package com.projeto.projetoapi.controller;

import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.client.CreditClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class CreditController {

    @Autowired
    private CreditClient creditClient;

    @GetMapping
    public CreditDTO getAllPosts(@RequestParam String id){
        return creditClient.getAllPosts();
    }


}
