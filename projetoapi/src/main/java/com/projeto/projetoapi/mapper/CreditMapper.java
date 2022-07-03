package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesCreditDTO;
import com.projeto.projetoapi.DTO.requests.CreditPUTByIdRequest;
import com.projeto.projetoapi.DTO.responses.CreditResponse;
import com.projeto.projetoapi.models.CreditModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(target = "id", ignore = true)
    CreditModel toCreditModel(CreditPUTByIdRequest creditPUTByIdRequest);

    CreditResponse toCreditGetByIdResponse(Optional<CreditModel> creditModelOptional);

    CreditResponse mapToCreditResponse(CreditModel creditModel);

    List<CreditModel> mapAllCreditDTOToCreditModel(List<AtributesCreditDTO> value);
}
