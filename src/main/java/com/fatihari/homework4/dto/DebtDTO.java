package com.fatihari.homework4.dto;

import com.fatihari.homework4.entity.UserAccount;

import javax.persistence.*;
import java.util.Date;

public class DebtDTO
{
    private Long id;
    private Double mainDebtAmount;
    private Double remainingDebtAmount;
    private Date startDate;
    private Date endDate;
    private Long user_account_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMainDebtAmount() {
        return mainDebtAmount;
    }

    public void setMainDebtAmount(Double mainDebtAmount) {
        this.mainDebtAmount = mainDebtAmount;
    }

    public Double getRemainingDebtAmount() {
        return remainingDebtAmount;
    }

    public void setRemainingDebtAmount(Double remainingDebtAmount) {
        this.remainingDebtAmount = remainingDebtAmount;
    }

    public Date getStartDateDate() {
        return startDate;
    }

    public void setStartDateDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(Long user_account_id) {
        this.user_account_id = user_account_id;
    }
}
