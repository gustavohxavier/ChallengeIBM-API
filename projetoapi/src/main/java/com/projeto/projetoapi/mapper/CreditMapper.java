package com.projeto.projetoapi.mapper;

import com.projeto.projetoapi.Dtos.AtributesCreditDTO;
import com.projeto.projetoapi.Dtos.requests.CreditRequest;
import com.projeto.projetoapi.Dtos.responses.ContractByYear;
import com.projeto.projetoapi.Dtos.responses.CreditResponse;
import com.projeto.projetoapi.models.CreditModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    CreditModel toCreditModel(CreditRequest creditRequest);


    CreditResponse mapToCreditResponse(CreditModel creditModel);

    List<CreditModel> mapAllCreditDTOToCreditModel(List<AtributesCreditDTO> value);

    List<CreditResponse> mapCreditModelListToCreditResponseList(List<CreditModel> creditModelList);

    ContractByYear mapCreditModelListToContractByYearList(CreditModel creditModelList);
}
