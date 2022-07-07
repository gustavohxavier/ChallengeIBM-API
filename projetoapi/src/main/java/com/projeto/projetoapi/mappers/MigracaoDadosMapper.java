package com.projeto.projetoapi.mappers;

import com.projeto.projetoapi.dtos.ContractDto;
import com.projeto.projetoapi.dtos.ContractDtoList;
import com.projeto.projetoapi.entities.ContractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigracaoDadosMapper {

    @Autowired
    ContractMapper contractMapper;

    public List<ContractEntity> mapCreditDTOToCreditModel(ContractDtoList contractDtoList) {
        List<ContractEntity> listSaida = new ArrayList<>();
        for (ContractDto contractDto : contractDtoList.getValue()) {
            ContractEntity contractEntity = new ContractEntity();
            StringBuilder nomeProduto = new StringBuilder(contractDto.getNomeProduto());
            int length = nomeProduto.length();
            nomeProduto = nomeProduto.deleteCharAt(length - 1);
            nomeProduto = nomeProduto.deleteCharAt(0);
            contractEntity.setNomeProduto(nomeProduto.toString());
            contractEntity.setNomeRegiao(contractDto.getNomeRegiao());
            contractEntity.setNomeUF(contractDto.getNomeUF());
            contractEntity.setMesEmissao(contractDto.getMesEmissao());
            contractEntity.setAnoEmissao(contractDto.getAnoEmissao());
            contractEntity.setCdPrograma(contractDto.getCdPrograma());
            contractEntity.setCdSubPrograma(contractDto.getCdSubPrograma());
            contractEntity.setCdFonteRecurso(contractDto.getCdFonteRecurso());
            contractEntity.setCdTipoSeguro(contractDto.getCdTipoSeguro());
            contractEntity.setQtdCusteio(contractDto.getQtdCusteio());
            contractEntity.setVlCusteio(contractDto.getVlCusteio());
            contractEntity.setAtividade(contractDto.getAtividade());
            contractEntity.setCdModalidade(contractDto.getCdModalidade());
            contractEntity.setAreaCusteio(contractDto.getAreaCusteio());

            listSaida.add(contractEntity);
        }
        return listSaida;
    }
}
