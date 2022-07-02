package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.responses.CreditPUTByIdResponse;
import com.projeto.projetoapi.mapper.CreditMapper;
import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private CreditMapper creditMapper;

    //Método que realiza o processo de onboarding dos dados da API externa através do FEIGN CLIENT
    @Scheduled(fixedDelay = 10000000L)
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

    public CreditPUTByIdResponse save(CreditModel creditModel) {

        CreditModel creditModel1 = creditRepository.save(creditModel);
        CreditPUTByIdResponse creditPUTByIdResponse = creditMapper.toCreditPUTByIdResponse(creditModel1);
        return creditPUTByIdResponse;
    }

    public Page<CreditModel> findAllPageable(Pageable pageable) {
        Page<CreditModel> creditModelPage = creditRepository.findAll(pageable);
        return creditModelPage;
    }

    /*public List<CreditModel> findByYear(String year) {
        List<CreditModel> creditModelList = migracaoDadosService.filterByYear(year);
    }*/
}
