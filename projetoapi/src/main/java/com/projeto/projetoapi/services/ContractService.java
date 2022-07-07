package com.projeto.projetoapi.services;

import com.projeto.projetoapi.clients.ContractClient;
import com.projeto.projetoapi.dtos.requests.ContractRequest;
import com.projeto.projetoapi.dtos.responses.ContractResponse;
import com.projeto.projetoapi.dtos.responses.ProductsByYear;
import com.projeto.projetoapi.entities.ContractEntity;
import com.projeto.projetoapi.mappers.ContractMapper;
import com.projeto.projetoapi.repositories.ContractRepository;
import com.projeto.projetoapi.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ContractClient contractClient;

    @Autowired
    private ProductsByYear productsByYear;


    //Método que realiza o processo de onboarding dos dados da API externa através do FEIGN CLIENT
    @Scheduled(fixedDelay = 10000000L)
    public void onboardingData(){

        List<ContractEntity> contractEntityList = contractMapper.mapAllCreditDTOToCreditModel((contractClient.getAllCredits()).getValue());
        contractRepository.saveAll(contractEntityList);
    }

    public List<ContractResponse> findByParam(ContractRequest contractRequest) {
        List<ContractResponse> contractResponseList = contractMapper.mapCreditModelListToCreditResponseList(contractRepository.findAll(Example.of(contractMapper.toCreditModel(contractRequest))));
        if(contractResponseList.isEmpty()) throw new EntityNotFoundException("Parameter Not Found");
        return contractResponseList;
    }

    //Deleta uma tupla do DB específica
    public void delete(Long id) {
        contractRepository.delete(contractRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Id " + id + " Not Found")));
    }

    public ContractResponse save(ContractRequest contractRequest) {
        return contractMapper.mapToCreditResponse(contractRepository.save(contractMapper.toCreditModel(contractRequest)));
    }

    public ContractResponse save(ContractRequest contractRequest, Long id) {
        ContractEntity contractEntity = contractRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Id " + id + " not found"));
        contractRequest.setId(id);
        return contractMapper.mapToCreditResponse(contractRepository.save(contractMapper.toCreditModel(contractRequest)));
    }

    public Page<ContractEntity> findAllPageable(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    public Object findByYear(String year) {

        Object[] soma = contractRepository.soma(year);
        if(soma.length == 0) throw new EntityNotFoundException("Year " + year + " not found");
        return soma;
    }
}
