package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesPostDTO;
import com.projeto.projetoapi.DTO.PostDTO;
import com.projeto.projetoapi.entities.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigracaoDadosMapper {


    public List<Value> mapPostDTOToValue(PostDTO allPosts) {
        List<Value> saida = new ArrayList<>();
        for (AtributesPostDTO atributesPostDTO : allPosts.getValue()){
            Value value = new Value();
            value.setAtividade(atributesPostDTO.getAtividade());
            value.setNomeProduto(atributesPostDTO.getNomeProduto());
            saida.add(value);

        }
        return saida;

    }
}
