package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.DTO.AtributesCreditDTO;
import com.projeto.projetoapi.DTO.requests.CreditPUTByIdRequest;
import com.projeto.projetoapi.DTO.responses.CreditGetByIdResponse;
import com.projeto.projetoapi.DTO.responses.CreditPUTByIdResponse;
import com.projeto.projetoapi.models.CreditModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(target = "id", ignore = true)
    CreditModel toCreditModel(CreditPUTByIdRequest creditPUTByIdRequest);

    CreditGetByIdResponse toCreditGetByIdResponse(Optional<CreditModel> creditModelOptional);

    @Mapping(target = "id", ignore = true)
    CreditPUTByIdResponse toCreditPUTByIdResponse(CreditModel creditModel);

    List<CreditModel> mapAllCreditDTOToCreditModel(List<AtributesCreditDTO> value);
}
