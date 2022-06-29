package com.projeto.projetoapi.repositories;

import com.projeto.projetoapi.DTO.AtributesPostDTO;
import com.projeto.projetoapi.entities.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long> {

}
