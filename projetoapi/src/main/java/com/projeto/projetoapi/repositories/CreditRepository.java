package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.models.CreditModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<CreditModel, Long> {

    /*@Query("SELECT nomeProduto, nomeRegiao, nomeUF, vlCusteio FROM TB_CONTRACTS WHERE anoEmissao = ? AND ")
    List<CreditModel> findByYear();*/
}
