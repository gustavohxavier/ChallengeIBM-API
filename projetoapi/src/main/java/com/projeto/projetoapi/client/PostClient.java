package com.projeto.projetoapi.client;

import com.projeto.projetoapi.DTO.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/aplicacao#!/recursos/ComercRegiaoUFProduto")
public interface PostClient {

    @GetMapping(value = "/posts")
    List<PostDTO> getAllPosts();
}
