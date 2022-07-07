package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.models.CreditModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<CreditModel, Long> {

    //List<CreditModel> findByAnoEmissaoAndNomeProdutoIn(String year, List<String> nomeProduto);

    @Query(value = "SELECT  SUM(vlCusteio) AS somaAno FROM CreditModel WHERE nomeProduto in ('SOJA', 'FEIJÃO', 'TRIGO', 'MILHO', 'CANA-DE-AÇUCAR') AND anoEmissao = ?1 GROUP BY nomeProduto ORDER BY nomeProduto ASC")
    Object[] soma(String year);

    /*@Query("SELECT nomeProduto, nomeRegiao, nomeUF, vlCusteio FROM TB_CONTRACTS WHERE anoEmissao = ? AND ")
    List<CreditModel> findByYear();*/
}
