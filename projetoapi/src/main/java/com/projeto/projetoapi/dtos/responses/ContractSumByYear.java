package com.projeto.projetoapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractSumByYear {

    private String nomeProduto;
    private BigDecimal somatorioAno;
}
