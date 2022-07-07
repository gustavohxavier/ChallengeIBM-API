package com.projeto.projetoapi.services;

import com.projeto.projetoapi.clients.ContractClient;
import com.projeto.projetoapi.dtos.requests.ContractRequest;
import com.projeto.projetoapi.dtos.responses.ContractResponse;
import com.projeto.projetoapi.dtos.responses.ContractSumByYear;
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

import java.math.BigDecimal;
import java.util.ArrayList;
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
        return contractMapper.mapCreditModelListToCreditResponseList(contractRepository.findAll(Example.of(contractMapper.toCreditModel(contractRequest))));
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

        List<ContractSumByYear> contractSumByYearList = new ArrayList<>();
        for(int i=0; i<soma.length;i++){
            ContractSumByYear contractSumByYear1 = new ContractSumByYear();
            contractSumByYear1.setSomaAno((BigDecimal) soma[i]);
            contractSumByYearList.add(contractSumByYear1);
        }
        contractSumByYearList.get(0).setNomeProduto(productsByYear.getPruduct1());
        contractSumByYearList.get(1).setNomeProduto(productsByYear.getPruduct2());
        contractSumByYearList.get(2).setNomeProduto(productsByYear.getPruduct3());
        contractSumByYearList.get(3).setNomeProduto(productsByYear.getPruduct4());
        contractSumByYearList.get(4).setNomeProduto(productsByYear.getPruduct5());

        return contractSumByYearList;

    }
}
