package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    @Query(value = "SELECT  nomeProduto, SUM(vlCusteio) AS somatorioAno FROM ContractEntity WHERE nomeProduto in (:products) AND anoEmissao = :year GROUP BY nomeProduto ORDER BY nomeProduto ASC")
    Object[] soma(String year, List<String> products);
}
