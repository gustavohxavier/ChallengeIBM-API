package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.requests.CreditRequest;
import com.projeto.projetoapi.DTO.responses.CreditResponse;
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

import java.util.List;

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
        //CreditModel creditModel = creditRepository.save(creditMapper.toCreditModel(creditRequest));
        /*if(creditRequestList.isEmpty())
            throw new EntityAlreadyExistException("Entity already exist.");*/

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

    public List<CreditModel> findByYear(String year) {
        return creditRepository.findByAnoEmissao(year);
    }

}
