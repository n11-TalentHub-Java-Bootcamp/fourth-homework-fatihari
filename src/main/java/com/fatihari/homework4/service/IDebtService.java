package com.fatihari.homework4.service;

import com.fatihari.homework4.entity.Debt;

import java.util.Date;
import java.util.List;

public interface IDebtService
{
	public List<Debt> findAll();
	public Debt save(Debt debt);
	public List<Debt> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);
	public List<Debt> findAllByUserAccount_Id(Long userId);
	public List<Debt> findAllByEndDateGreaterThanEqual(Date endDate);
	public Double findTotalDebt(Long userId);
	public Double findTotalOverdueDebt(Long userId);
	//public Double findInstantLateFee();
}
