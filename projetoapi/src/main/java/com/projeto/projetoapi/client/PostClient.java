package com.projeto.projetoapi.client;

import com.projeto.projetoapi.DTO.PostDTO;
import com.projeto.projetoapi.entities.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto?$top=10&$format=json")
public interface PostClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    PostDTO getAllPosts();

}
