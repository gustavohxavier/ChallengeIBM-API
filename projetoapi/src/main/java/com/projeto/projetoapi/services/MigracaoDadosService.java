package com.projeto.projetoapi.services;

import com.projeto.projetoapi.DTO.PostDTO;
import com.projeto.projetoapi.client.PostClient;
import com.projeto.projetoapi.entities.Value;
import com.projeto.projetoapi.mapper.MigracaoDadosMapper;
import com.projeto.projetoapi.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigracaoDadosService {

    @Autowired
    private PostClient postClient;

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private MigracaoDadosMapper migracaoDadosMapper;

    public void migrar(){
        PostDTO allPosts = postClient.getAllPosts();
        List<Value> listValue = migracaoDadosMapper.mapPostDTOToValue(allPosts);
        valueRepository.saveAll(listValue);
    }
}
