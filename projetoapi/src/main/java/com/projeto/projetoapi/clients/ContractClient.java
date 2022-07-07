package com.projeto.projetoapi.clients;

import com.projeto.projetoapi.dtos.ContractDtoList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "contract", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto")
public interface ContractClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    ContractDtoList getAllCredits();

}
