package com.projeto.projetoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor //cria construtor com argumentos
@NoArgsConstructor  //cria construtor sem argumentos
//@Builder(toBuilder = true)
public class ContractDtoList {

        List<ContractDto> value;

}
