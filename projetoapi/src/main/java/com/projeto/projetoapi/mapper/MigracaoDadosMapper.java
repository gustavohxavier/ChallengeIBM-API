package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesCreditDTO;
import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.entities.Credit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigracaoDadosMapper {


    public List<Credit> mapPostDTOToValue(CreditDTO allPosts) {
        List<Credit> saida = new ArrayList<>();
        for (AtributesCreditDTO atributesCreditDTO : allPosts.getValue()){
            Credit credit = new Credit();
            credit.setAtividade(atributesCreditDTO.getAtividade());
            credit.setNomeProduto(atributesCreditDTO.getNomeProduto());
            saida.add(credit);

        }
        return saida;

    }
}
