package com.projeto.projetoapi.DTO.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreditPUTByIdRequest {

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
