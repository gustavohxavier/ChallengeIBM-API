package com.projeto.projetoapi.DTO.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@NoArgsConstructor
public class ContractByYear {

    private String NomeProduto;
    private BigDecimal vlCusteio;
}
