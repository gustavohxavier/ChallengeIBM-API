package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.client.CreditClient;
import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.mapper.MigracaoDadosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigracaoDadosService {

    @Autowired
    private CreditClient creditClient;

    @Autowired
    private MigracaoDadosMapper migracaoDadosMapper;

    public List<CreditModel> migrar(){
        CreditDTO allCredits = creditClient.getAllCredits();
        List<CreditModel> listCreditModel = migracaoDadosMapper.mapCreditDTOToCredit(allCredits);
        return listCreditModel;
    }
}
