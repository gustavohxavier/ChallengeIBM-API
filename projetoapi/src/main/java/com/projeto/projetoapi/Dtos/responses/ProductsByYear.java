package com.projeto.projetoapi.Dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductsByYear {

    private String pruduct4 = "SOJA";
    private String pruduct2 = "FEIJÃO";
    private String pruduct5 = "TRIGO";
    private String pruduct3 = "MILHO";
    private String pruduct1 = "CANA-DE-AÇUCAR";
}
