package com.fatihari.homework4.converter;

import com.fatihari.homework4.dto.DebtDTO;
import com.fatihari.homework4.entity.Debt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DebtConverter
{
	public DebtConverter INSTANCE = Mappers.getMapper(DebtConverter.class);
	
	@Mapping(source="user_account_id", target = "userAccount.id") // source => DebtDto, target=> Debt
	Debt convertFromDebtDtoToDebt(DebtDTO debtDTO);
	

}
