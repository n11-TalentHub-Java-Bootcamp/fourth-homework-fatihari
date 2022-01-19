package com.fatihari.homework4.dao;

import com.fatihari.homework4.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long>
{
	List<Debt> findAllByUserAccount_Id(Long userId);
	List<Debt> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);
	List<Debt> findAllByEndDateGreaterThanEqual(Date endDate);

	public static final String FIND_TOTAL_DEBT = "SELECT SUM(main_debt_amount) FROM debt JOIN user_account ON debt.user_account_id = user_account.id WHERE debt.user_account_id =:userId";
	@Query(value = FIND_TOTAL_DEBT, nativeQuery = true)
	public double findTotalDebt(Long userId);

	public static final String FIND_TOTAL_OVERDUE_DEBT = "SELECT SUM(main_debt_amount) FROM debt JOIN user_account ON debt.user_account_id = user_account.id WHERE debt.end_date<now() AND debt.user_account_id =:userId";
	@Query(value = FIND_TOTAL_OVERDUE_DEBT, nativeQuery = true)
	public double findTotalOverdueDebt(Long userId);

	/*
	public static final String FIND_INSANT_LATE_FEE = "SELECT projectId, projectName FROM projects";
*/
}
