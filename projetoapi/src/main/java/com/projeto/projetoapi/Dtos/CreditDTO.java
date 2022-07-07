package com.projeto.projetoapi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor //cria construtor com argumentos
@NoArgsConstructor  //cria construtor sem argumentos
//@Builder(toBuilder = true)
public class CreditDTO {

        List<AtributesCreditDTO> value;

}
