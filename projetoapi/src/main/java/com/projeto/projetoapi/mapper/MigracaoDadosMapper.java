package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesCreditDTO;
import com.projeto.projetoapi.DTO.CreditDTO;
import com.projeto.projetoapi.models.CreditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigracaoDadosMapper {

    @Autowired
    CreditMapper creditMapper;

    public List<CreditModel> mapCreditDTOToCreditModel(CreditDTO creditDTO) {
        List<CreditModel> listSaida = new ArrayList<>();
        for (AtributesCreditDTO atributesCreditDTO : creditDTO.getValue()){
            CreditModel creditModel = new CreditModel();
            creditModel.setNomeProduto(atributesCreditDTO.getNomeProduto());
            creditModel.setNomeRegiao(atributesCreditDTO.getNomeRegiao());
            creditModel.setNomeUF(atributesCreditDTO.getNomeUF());
            creditModel.setMesEmissao(atributesCreditDTO.getMesEmissao());
            creditModel.setAnoEmissao(atributesCreditDTO.getAnoEmissao());
            creditModel.setCdPrograma(atributesCreditDTO.getCdPrograma());
            creditModel.setCdSubPrograma(atributesCreditDTO.getCdSubPrograma());
            creditModel.setCdFonteRecurso(atributesCreditDTO.getCdFonteRecurso());
            creditModel.setCdTipoSeguro(atributesCreditDTO.getCdTipoSeguro());
            creditModel.setQtdCusteio(atributesCreditDTO.getQtdCusteio());
            creditModel.setVlCusteio(atributesCreditDTO.getVlCusteio());
            creditModel.setAtividade(atributesCreditDTO.getAtividade());
            creditModel.setCdModalidade(atributesCreditDTO.getCdModalidade());
            creditModel.setAreaCusteio(atributesCreditDTO.getAreaCusteio());

            listSaida.add(creditModel);
        }
        return listSaida;
    }


    public CreditModel mapAtributesCreditDTOToCreditModel(AtributesCreditDTO atributesCreditDTO) {
        CreditModel creditModel = new CreditModel();
        /*creditModel.setNomeProduto(atributesCreditDTO.getNomeProduto());
        creditModel.setNomeRegiao(atributesCreditDTO.getNomeRegiao());
        creditModel.setNomeUF(atributesCreditDTO.getNomeUF());
        creditModel.setMesEmissao(atributesCreditDTO.getMesEmissao());
        creditModel.setAnoEmissao(atributesCreditDTO.getAnoEmissao());
        creditModel.setCdPrograma(atributesCreditDTO.getCdPrograma());
        creditModel.setCdSubPrograma(atributesCreditDTO.getCdSubPrograma());
        creditModel.setCdFonteRecurso(atributesCreditDTO.getCdFonteRecurso());
        creditModel.setCdTipoSeguro(atributesCreditDTO.getCdTipoSeguro());
        creditModel.setQtdCusteio(atributesCreditDTO.getQtdCusteio());
        creditModel.setVlCusteio(atributesCreditDTO.getVlCusteio());
        creditModel.setAtividade(atributesCreditDTO.getAtividade());
        creditModel.setCdModalidade(atributesCreditDTO.getCdModalidade());
        creditModel.setAreaCusteio(atributesCreditDTO.getAreaCusteio());*/

        creditModel = creditMapper.toCreditModel(atributesCreditDTO);

        return creditModel;
    }
}
