package com.projeto.projetoapi.services;

import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private MigracaoDadosService migracaoDadosService;

    @Autowired
    private CreditRepository creditRepository;

    @Scheduled(fixedDelay = 1000000L)
    public void iniciar(){

        List<CreditModel> creditModelList = migracaoDadosService.migrar();
        creditRepository.saveAll(creditModelList);
    }

    public List<CreditModel> findAll() {
        return creditRepository.findAll();
    }

}
