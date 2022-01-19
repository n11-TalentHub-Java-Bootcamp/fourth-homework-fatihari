package com.fatihari.homework4.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "debt")
@JsonIgnoreProperties({"userAccount"})
public class Debt
{
	@SequenceGenerator(name = "generator", sequenceName = "debt_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

	@Column(name = "main_debt_amount")
    private Double mainDebtAmount;

    @Column(name = "remaining_debt_amount")
    private Double remainingDebtAmount;

    @Column(name = "start_date")
	@Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
	@Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", foreignKey = @ForeignKey(name = "fk_debt_user_account_id"))
    private UserAccount userAccount;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Double getRemainingDebtAmount() {
		return remainingDebtAmount;
	}

	public void setRemainingDebtAmount(Double remainingDebtAmount) {
		this.remainingDebtAmount = remainingDebtAmount;
	}

	@Override
	public String toString() {
		return "Debt{" +
				"id=" + id +
				", mainDebtAmount=" + mainDebtAmount +
				", remainingDebtAmount=" + remainingDebtAmount +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", userAccount=" + userAccount +
				'}';
	}
}
