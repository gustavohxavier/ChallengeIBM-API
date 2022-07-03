package com.projeto.projetoapi.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CONTRACTS")
public class CreditModel {
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    private String mesEmissao;
    private String anoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private Double qtdCusteio;
    private BigDecimal vlCusteio;
    private String atividade;
    private String cdModalidade;
    private Double areaCusteio;
}
