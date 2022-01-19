package com.fatihari.homework4.service;

import com.fatihari.homework4.dao.DebtRepository;
import com.fatihari.homework4.entity.Debt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DebtService implements IDebtService{
    @Autowired
    private DebtRepository debtRepository;

    @Autowired
    public DebtService(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

    @Override
    public List<Debt> findAll() {
        return this.debtRepository.findAll();
    }

    @Override
    public Debt save(Debt debt) {
        return this.debtRepository.save(debt);
    }

    @Override
    public List<Debt> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate) {
        return this.debtRepository.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(endDate, startDate);
    }

    @Override
    public List<Debt> findAllByUserAccount_Id(Long userId) {
        return this.debtRepository.findAllByUserAccount_Id(userId);
    }

    @Override
    public List<Debt> findAllByEndDateGreaterThanEqual(Date endDate) {
        return this.debtRepository.findAllByEndDateGreaterThanEqual(endDate);
    }

    @Override
    public Double findTotalDebt(Long userId) {
        return this.debtRepository.findTotalDebt(userId);
    }
    @Override
    public Double findTotalOverdueDebt(Long userId) {
        return this.debtRepository.findTotalOverdueDebt(userId);
    }

}
