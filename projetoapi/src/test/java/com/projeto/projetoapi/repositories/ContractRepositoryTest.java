package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.entities.ContractEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

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

    @Test
    @DisplayName("Update a Contract on DB")
    void shouldUpdateAContract(){
        //given
        ContractEntity contractToBeSaved = createContractEntity();

        //when
        ContractEntity contractSaved = this.contractRepository.save(contractToBeSaved);
        contractSaved.setNomeProduto("Outro");
        ContractEntity contractUpdated = this.contractRepository.save(contractSaved);

        //then
        Assertions.assertThat(contractUpdated).isNotNull();
        Assertions.assertThat(contractUpdated.getId()).isNotNull();
        Assertions.assertThat(contractUpdated.getNomeProduto()).isEqualTo(contractSaved.getNomeProduto());
    }

    @Test
    @DisplayName("Delete a Contract on DB")
    void shouldDeleteAContract(){
        //given
        ContractEntity contractToBeSaved = createContractEntity();

        //when
        ContractEntity contractSaved = this.contractRepository.save(contractToBeSaved);
        this.contractRepository.delete(contractSaved);
        Optional<ContractEntity> optionalContract = this.contractRepository.findById(contractSaved.getId());

        //then
        Assertions.assertThat(optionalContract).isEmpty();

    }

    /*
     *
     * Teste não implementado
     *
     */
    /*@Test
    @DisplayName("Find by year returns sum of a Contracts on DB whose nomeProduto are CANA-DE-AÇUCAR, FEIJÃO, MILHO, SOJA and TRIGO")
    void shouldSumByYearContracts(){
        //given
        List<String> stringList = Arrays.asList("CANA-DE-AÇUCAR", "FEIJÃO", "MILHO", "SOJA", "TRIGO");
        String year = "2022";
        List<ContractEntity> contractEntityListToBeSaved = createContractEntityList();
        List<ContractSumByYear> contractSumByYears = createContractSum();

        //when
        List<ContractEntity> contractEntityListSaved = this.contractRepository.saveAll(contractEntityListToBeSaved);
        Object[] soma = contractRepository.sumYear(year, stringList);
        List<ContractSumByYear> list = new ArrayList<>();
        for (Object obj : soma) {
            ContractSumByYear contractSumByYear1 = new ContractSumByYear();
            contractSumByYear1.setNomeProduto((String) Array.get(obj, 0));
            contractSumByYear1.setSomatorioAno((BigDecimal) Array.get(obj, 1));
            list.add(contractSumByYear1);
        }


        //then
        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list).containsAll(contractSumByYears);

    }*/

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

    /*private List<ContractEntity> createContractEntityList(){
        var contract1 = ContractEntity.builder()
                .id(1L)
                .nomeProduto("SOJA")
                .nomeRegiao("SUDESTE")
                .nomeUF("RJ")
                .mesEmissao("10")
                .anoEmissao("2022")
                .cdPrograma("25")
                .cdSubPrograma("251")
                .cdFonteRecurso("GUSTAVO")
                .cdTipoSeguro("SAFE")
                .qtdCusteio(20.0)
                .vlCusteio(new BigDecimal(20.00))
                .atividade("ATIVIDADE")
                .cdModalidade("MODALIDADE")
                .areaCusteio(30.0).build();

        var contract2 = ContractEntity.builder()
                .id(1L)
                .nomeProduto("SOJA")
                .nomeRegiao("SUDESTE")
                .nomeUF("RJ")
                .mesEmissao("10")
                .anoEmissao("2022")
                .cdPrograma("25")
                .cdSubPrograma("251")
                .cdFonteRecurso("GUSTAVO")
                .cdTipoSeguro("SAFE")
                .qtdCusteio(20.0)
                .vlCusteio(new BigDecimal(30.00))
                .atividade("ATIVIDADE")
                .cdModalidade("MODALIDADE")
                .areaCusteio(30.0).build();
        var contract3 = ContractEntity.builder()
                .id(1L)
                .nomeProduto("MILHO")
                .nomeRegiao("SUDESTE")
                .nomeUF("RJ")
                .mesEmissao("10")
                .anoEmissao("2022")
                .cdPrograma("25")
                .cdSubPrograma("251")
                .cdFonteRecurso("GUSTAVO")
                .cdTipoSeguro("SAFE")
                .qtdCusteio(20.0)
                .vlCusteio(new BigDecimal(40.00))
                .atividade("ATIVIDADE")
                .cdModalidade("MODALIDADE")
                .areaCusteio(30.0).build();

        var contract4 = ContractEntity.builder()
                .id(1L)
                .nomeProduto("MILHO")
                .nomeRegiao("SUDESTE")
                .nomeUF("RJ")
                .mesEmissao("10")
                .anoEmissao("2020")
                .cdPrograma("25")
                .cdSubPrograma("251")
                .cdFonteRecurso("GUSTAVO")
                .cdTipoSeguro("SAFE")
                .qtdCusteio(20.0)
                .vlCusteio(new BigDecimal(50.00))
                .atividade("ATIVIDADE")
                .cdModalidade("MODALIDADE")
                .areaCusteio(30.0).build();

        return Arrays.asList(contract1, contract2, contract3, contract4);
    }

    private List<ContractSumByYear> createContractSum(){
        var contract1 = ContractSumByYear.builder().nomeProduto("CANA-DE-AÇUCAR").somatorioAno(new BigDecimal("25000.00")).build();
        var contract2 = ContractSumByYear.builder().nomeProduto("FEIJÃO").somatorioAno(new BigDecimal("30000.00")).build();
        var contract3 = ContractSumByYear.builder().nomeProduto("MILHO").somatorioAno(new BigDecimal("40.00")).build();
        var contract4 = ContractSumByYear.builder().nomeProduto("SOJA").somatorioAno(new BigDecimal("50.00")).build();
        var contract5 = ContractSumByYear.builder().nomeProduto("TRIGO").somatorioAno(new BigDecimal("45000.00")).build();
        return Arrays.asList(contract1, contract2, contract3, contract4, contract5);
    }*/
}