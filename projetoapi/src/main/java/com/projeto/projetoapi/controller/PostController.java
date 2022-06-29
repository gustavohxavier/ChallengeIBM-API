package com.projeto.projetoapi.controller;

import com.projeto.projetoapi.DTO.PostDTO;
import com.projeto.projetoapi.client.PostClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostClient postClient;

    @GetMapping
    public String getAllPosts(){
        return postClient.getAllPosts();
    }
}
