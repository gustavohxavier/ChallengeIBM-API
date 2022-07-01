package com.projeto.projetoapi.services;

import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    @Autowired
    private MigracaoDadosService migracaoDadosService;

    @Autowired
    private CreditRepository creditRepository;

    //Método que realiza o processo de onboarding dos dados da API externa através do FEIGN CLIENT
    @Scheduled(fixedDelay = 1000000L)
    public void iniciar(){

        List<CreditModel> creditModelList = migracaoDadosService.feignClientMigrar();
        creditRepository.saveAll(creditModelList);
    }

    //Retorna todos os dados recuperados do DB
    public List<CreditModel> findAll() {
        return creditRepository.findAll();
    }

    //Retorna uma tupla do DB buscada por ID
    public Optional<CreditModel> findById(Long id) {
        return creditRepository.findById(id);
    }

    //Deleta uma tupla do DB específica
    public void delete(CreditModel creditModel) {
        creditRepository.delete(creditModel);
    }

    public CreditModel save(CreditModel creditModel) {
        return creditRepository.save(creditModel);
    }
}
