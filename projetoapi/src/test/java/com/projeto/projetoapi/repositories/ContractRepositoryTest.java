package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.entities.ContractEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
@DisplayName("Tests for Contract Repository")
class ContractRepositoryTest {
    @Autowired
    private ContractRepository contractRepository;

    @Test
    @DisplayName("Save a Contract on DB")
    void shouldSaveAContract(){
        //given
        ContractEntity contractToBeSaved = createContractEntity();
        //when
        ContractEntity contractSaved = this.contractRepository.save(contractToBeSaved);
        //then
        Assertions.assertThat(contractSaved).isNotNull();
        Assertions.assertThat(contractSaved.getId()).isNotNull();
        Assertions.assertThat(contractSaved.getNomeProduto()).isEqualTo(contractToBeSaved.getNomeProduto());
    }

    private ContractEntity createContractEntity(){
        return ContractEntity.builder()
                .id(1L)
                .nomeProduto("MACARRÃO")
                .nomeRegiao("SUDESTE")
                .nomeUF("RJ")
                .mesEmissao("10")
                .anoEmissao("2022")
                .cdPrograma("25")
                .cdSubPrograma("251")
                .cdFonteRecurso("GUSTAVO")
                .cdTipoSeguro("SAFE")
                .qtdCusteio(20.0)
                .vlCusteio(new BigDecimal(25.00))
                .atividade("ATIVIDADE")
                .cdModalidade("MODALIDADE")
                .areaCusteio(30.0).build();
    }
}