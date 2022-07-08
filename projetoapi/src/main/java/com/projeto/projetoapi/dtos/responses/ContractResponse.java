package com.projeto.projetoapi.dtos.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonPropertyOrder(value = "id, nomeProduto, nomeRegiao, nomeUF, mesEmissao, anoEmissao, vlCusteio")
public class ContractResponse {

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
    private Double vlCusteio;
    private String atividade;
    private String cdModalidade;
    private Double areaCusteio;
}
