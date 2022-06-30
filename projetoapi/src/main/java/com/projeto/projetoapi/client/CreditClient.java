package com.projeto.projetoapi.client;

import com.projeto.projetoapi.DTO.CreditDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto?$top=10&$format=json")
public interface CreditClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    CreditDTO getAllPosts();

}
