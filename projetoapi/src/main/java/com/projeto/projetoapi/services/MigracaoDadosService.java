package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.DTO.requests.CreditPUTByIdRequest;
import com.projeto.projetoapi.client.CreditClient;
import com.projeto.projetoapi.mapper.CreditMapper;
import com.projeto.projetoapi.mapper.MigracaoDadosMapper;
import com.projeto.projetoapi.models.CreditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigracaoDadosService {

    @Autowired
    private CreditClient creditClient;

    @Autowired
    private MigracaoDadosMapper migracaoDadosMapper;

    @Autowired
    CreditMapper creditMapper;

    //Migrar os dados da API externa que chegam via FEIGN CLIENT
    public List<CreditModel> feignClientMigrar(){
        CreditDTO allCredits = creditClient.getAllCredits();
        //List<CreditModel> listCreditModel = migracaoDadosMapper.mapCreditDTOToCreditModel(allCredits);
        List<CreditModel> creditModelList = creditMapper.mapAllCreditDTOToCreditModel(allCredits.getValue());
        return creditModelList;
    }

    //Migrar os dados que chegam via Request HTTP
    public CreditModel webClientMigrar (CreditPUTByIdRequest creditPUTByIdRequest, Long id){
        CreditModel creditModel = creditMapper.toCreditModel(creditPUTByIdRequest);
        creditModel.setId(id);
        return creditModel;
    }

    /*public List<CreditModel> filterByYear(String year) {

    }*/
}
