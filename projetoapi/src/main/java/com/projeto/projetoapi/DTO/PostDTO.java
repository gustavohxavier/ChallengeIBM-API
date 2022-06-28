package com.projeto.projetoapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //cria construtor com argumentos
@NoArgsConstructor  //cria construtor sem argumentos
//@Builder(toBuilder = true)
public class PostDTO {
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
