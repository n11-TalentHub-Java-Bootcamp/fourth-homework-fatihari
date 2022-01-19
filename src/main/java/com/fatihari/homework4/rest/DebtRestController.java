package com.fatihari.homework4.rest;

import com.fatihari.homework4.converter.CommentConverter;
import com.fatihari.homework4.converter.DebtConverter;
import com.fatihari.homework4.dto.DebtDTO;
import com.fatihari.homework4.dto.ProductCommentDTO;
import com.fatihari.homework4.entity.Debt;
import com.fatihari.homework4.entity.Product;
import com.fatihari.homework4.entity.ProductComment;
import com.fatihari.homework4.entity.UserAccount;
import com.fatihari.homework4.exception.NotFoundException;
import com.fatihari.homework4.service.ICommentService;
import com.fatihari.homework4.service.IDebtService;
import com.fatihari.homework4.service.IProductService;
import com.fatihari.homework4.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/debts/")
public class DebtRestController {

	@Autowired
	private IDebtService iDebtService;

	@Autowired
	private IUserAccountService iUserAccountService;

	public DebtRestController(IDebtService iDebtService, IUserAccountService iUserAccountService) {
		this.iDebtService = iDebtService;
		this.iUserAccountService = iUserAccountService;
	}

	@GetMapping("")
    public List<Debt> findAll(){

        List<Debt> debts = iDebtService.findAll();

        return debts;
    }

	// Borç-a
	@PostMapping("")
	public Debt save(@RequestBody DebtDTO debtDTO)
	{
		Debt debt =  DebtConverter.INSTANCE.convertFromDebtDtoToDebt(debtDTO);
		iDebtService.save(debt);
		return debt;
	}

	// Borç-d
	@GetMapping("/{startDate}/{endDate}")
	public List<Debt> findAllByBetweenDatesSpecified(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
	{
		List<Debt> debts = this.iDebtService.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
		if(debts.isEmpty())
			throw new NotFoundException("Can not find any debts.");
		return debts;
	}

	//	Borç-e
	@GetMapping("/users/{userId}") //userId parameter
	public List<Debt> findAllByUserAccountId(@PathVariable Long userId)
	{
		List<Debt> debts = this.iDebtService.findAllByUserAccount_Id(userId);
		UserAccount userAccount = this.iUserAccountService.findById(userId);
		if(debts.isEmpty())
			throw new NotFoundException("UserId: " + userId +" - User \'" + userAccount.getUsername() + "\' hasn't any debts yet.");
		return debts;
	}

	// Borç-f
	@GetMapping("/userId/{endDate}")
	public List<Debt> findAllByEndDateGreaterThanEqual(@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
	{
		List<Debt> debts = this.iDebtService.findAllByEndDateGreaterThanEqual(endDate);
		if(debts.isEmpty())
			throw new NotFoundException("Can not find any debts.");
		return debts;
	}

	// Borç-g
	@GetMapping("totalDebt/{userId}")
	public double findTotalDebt(@PathVariable Long userId)
	{
		return this.iDebtService.findTotalDebt(userId);
	}

	// Borç-h
	@GetMapping("totalOverdueDebt/{userId}")
	public double findTotalOverdueDebt(@PathVariable Long userId)
	{
		return this.iDebtService.findTotalOverdueDebt(userId);
	}



}
