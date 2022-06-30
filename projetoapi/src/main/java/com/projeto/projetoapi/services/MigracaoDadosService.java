package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.client.CreditClient;
import com.projeto.projetoapi.entities.Credit;
import com.projeto.projetoapi.mapper.MigracaoDadosMapper;
import com.projeto.projetoapi.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigracaoDadosService {

    @Autowired
    private CreditClient creditClient;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private MigracaoDadosMapper migracaoDadosMapper;

    public void migrar(){
        CreditDTO allPosts = creditClient.getAllPosts();
        List<Credit> listCredit = migracaoDadosMapper.mapPostDTOToValue(allPosts);
        creditRepository.saveAll(listCredit);
    }
}
