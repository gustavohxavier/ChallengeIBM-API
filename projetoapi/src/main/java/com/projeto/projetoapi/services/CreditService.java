package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.requests.CreditPUTByIdRequest;
import com.projeto.projetoapi.DTO.responses.CreditResponse;
import com.projeto.projetoapi.client.CreditClient;
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
    private CreditRepository creditRepository;

    @Autowired
    private CreditMapper creditMapper;

    @Autowired
    private CreditClient creditClient;

    //Método que realiza o processo de onboarding dos dados da API externa através do FEIGN CLIENT
    @Scheduled(fixedDelay = 10000000L)
    public void onboardingData(){

        //List<CreditModel> creditModelList = migracaoDadosService.feignClientMigrar();
        List<CreditModel> creditModelList = creditMapper.mapAllCreditDTOToCreditModel((creditClient.getAllCredits()).getValue());
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

    public CreditResponse save(CreditModel creditModel) {
        return creditMapper.mapToCreditResponse(creditRepository.save(creditModel));
    }

    public CreditResponse save(CreditPUTByIdRequest creditPUTByIdRequest, Long id) {
        CreditModel creditModel = creditMapper.toCreditModel(creditPUTByIdRequest);
        creditModel.setId(id);
        return creditMapper.mapToCreditResponse(creditRepository.save(creditModel));
    }

    public Page<CreditModel> findAllPageable(Pageable pageable) {
        return creditRepository.findAll(pageable);
    }

    public List<CreditModel> findByYear(String year) {
        return creditRepository.findByAnoEmissao(year);
    }

}
