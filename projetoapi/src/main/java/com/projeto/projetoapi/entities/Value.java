package com.projeto.projetoapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Value {

    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    private String mesEmissao;
    private String anoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    private Integer qtdCusteio;
    private Long vlCusteio;
    private String atividade;
    private String cdModalidade;
    private Long areaCusteio;
}
