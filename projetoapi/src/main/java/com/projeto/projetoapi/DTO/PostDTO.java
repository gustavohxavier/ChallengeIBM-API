package com.projeto.projetoapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor //cria construtor com argumentos
@NoArgsConstructor  //cria construtor sem argumentos
//@Builder(toBuilder = true)
public class PostDTO {

        List<AtributesPostDTO> value;

}
