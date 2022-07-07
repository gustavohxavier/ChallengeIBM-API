package com.projeto.projetoapi.Dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractByYear {

    private String nomeProduto;
    private BigDecimal somaAno;
}
