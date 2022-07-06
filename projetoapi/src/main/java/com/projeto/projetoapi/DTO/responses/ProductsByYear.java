package com.projeto.projetoapi.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductsByYear {

    private String pruduct1 = "SOJA";
    private String pruduct2 = "FEIJÃO";
    private String pruduct3 = "TRIGO";
    private String pruduct4 = "MILHO";
    private String pruduct5 = "CANA-DE-AÇUCAR";
}
