package com.projeto.projetoapi.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.projeto.projetoapi.configs.Deserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtributesCreditDTO {

    @JsonDeserialize(using = Deserialize.class)
    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    @JsonProperty("MesEmissao")
    private String mesEmissao;
    @JsonProperty("AnoEmissao")
    private String anoEmissao;
    private String cdPrograma;
    private String cdSubPrograma;
    private String cdFonteRecurso;
    private String cdTipoSeguro;
    @JsonProperty("QtdCusteio")
    private Double qtdCusteio;
    @JsonProperty("VlCusteio")
    private BigDecimal vlCusteio;
    @JsonProperty("Atividade")
    private String atividade;
    private String cdModalidade;
    @JsonProperty("AreaCusteio")
    private Double areaCusteio;
}
