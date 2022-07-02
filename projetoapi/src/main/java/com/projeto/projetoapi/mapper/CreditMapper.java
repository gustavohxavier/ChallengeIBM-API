package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesCreditDTO;
import com.projeto.projetoapi.models.CreditModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(target = "id", ignore = true)
    CreditModel toCreditModel(AtributesCreditDTO atributesCreditDTO);
}
