package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    @Query(value = "SELECT  SUM(vlCusteio) AS somaAno FROM ContractEntity WHERE nomeProduto in ('SOJA', 'FEIJÃO', 'TRIGO', 'MILHO', 'CANA-DE-AÇUCAR') AND anoEmissao = ?1 GROUP BY nomeProduto ORDER BY nomeProduto ASC")
    Object[] soma(String year);
}
