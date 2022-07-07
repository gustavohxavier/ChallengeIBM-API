package com.projeto.projetoapi.services;

import com.projeto.projetoapi.Dtos.requests.CreditRequest;
import com.projeto.projetoapi.Dtos.responses.ContractByYear;
import com.projeto.projetoapi.Dtos.responses.CreditResponse;
import com.projeto.projetoapi.Dtos.responses.ProductsByYear;
import com.projeto.projetoapi.client.CreditClient;
import com.projeto.projetoapi.mapper.CreditMapper;
import com.projeto.projetoapi.models.CreditModel;
import com.projeto.projetoapi.repositories.CreditRepository;
import com.projeto.projetoapi.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private CreditMapper creditMapper;

    @Autowired
    private CreditClient creditClient;

    @Autowired
    private ProductsByYear productsByYear;


    //Método que realiza o processo de onboarding dos dados da API externa através do FEIGN CLIENT
    @Scheduled(fixedDelay = 10000000L)
    public void onboardingData(){

        List<CreditModel> creditModelList = creditMapper.mapAllCreditDTOToCreditModel((creditClient.getAllCredits()).getValue());
        creditRepository.saveAll(creditModelList);
    }

    //Retorna todos os dados recuperados do DB
    public List<CreditResponse> findAll() {
        List<CreditModel> creditModelList = creditRepository.findAll();
        return creditMapper.mapCreditModelListToCreditResponseList(creditModelList);
    }

    //Retorna uma tupla do DB buscada por ID
    public CreditResponse findById(Long id) {
        return creditMapper.mapToCreditResponse(creditRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Id " + id + " Not Found")));
    }

    //Deleta uma tupla do DB específica
    public void delete(Long id) {
        creditRepository.delete(creditRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Id " + id + " Not Found")));
    }

    public CreditResponse save(CreditRequest creditRequest) {
        return creditMapper.mapToCreditResponse(creditRepository.save(creditMapper.toCreditModel(creditRequest)));
    }

    public CreditResponse save(CreditRequest creditRequest, Long id) {
        CreditModel creditModel = creditRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Id " + id + " not found"));
        creditRequest.setId(id);
        return creditMapper.mapToCreditResponse(creditRepository.save(creditMapper.toCreditModel(creditRequest)));
    }

    public Page<CreditModel> findAllPageable(Pageable pageable) {
        return creditRepository.findAll(pageable);
    }

    public Object findByYear(String year) {

        Object[] soma = creditRepository.soma(year);
        if(soma.length == 0) throw new EntityNotFoundException("Year " + year + " not found");

        List<ContractByYear> contractByYearList = new ArrayList<>();
        for(int i=0; i<soma.length;i++){
            ContractByYear contractByYear1 = new ContractByYear();
            contractByYear1.setSomaAno((BigDecimal) soma[i]);
            contractByYearList.add(contractByYear1);
        }
        contractByYearList.get(0).setNomeProduto(productsByYear.getPruduct1());
        contractByYearList.get(1).setNomeProduto(productsByYear.getPruduct2());
        contractByYearList.get(2).setNomeProduto(productsByYear.getPruduct3());
        contractByYearList.get(3).setNomeProduto(productsByYear.getPruduct4());
        contractByYearList.get(4).setNomeProduto(productsByYear.getPruduct5());

        return contractByYearList;

    }
}
