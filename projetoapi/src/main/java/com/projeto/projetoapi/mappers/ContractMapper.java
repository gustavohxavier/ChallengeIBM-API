package com.projeto.projetoapi.mappers;

import com.projeto.projetoapi.dtos.ContractDto;
import com.projeto.projetoapi.dtos.requests.ContractRequest;
import com.projeto.projetoapi.dtos.responses.ContractResponse;
import com.projeto.projetoapi.entities.ContractEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractEntity toCreditModel(ContractRequest contractRequest);

    ContractResponse mapToCreditResponse(ContractEntity contractEntity);

    List<ContractEntity> mapAllCreditDTOToCreditModel(List<ContractDto> value);

    List<ContractResponse> mapCreditModelListToCreditResponseList(List<ContractEntity> contractEntityList);

    //List<ContractSumByYear> mapObjectListToContractSumByYearList(List<Object> objectList);
}
