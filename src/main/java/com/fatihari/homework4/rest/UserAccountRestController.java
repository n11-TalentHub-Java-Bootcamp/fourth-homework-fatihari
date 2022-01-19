package com.fatihari.homework4.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatihari.homework4.entity.UserAccount;
import com.fatihari.homework4.exception.NotFoundException;
import com.fatihari.homework4.service.IUserAccountService;

@RestController
@RequestMapping("/api/users/")
public class UserAccountRestController {
	
	@Autowired
	private IUserAccountService iUserAccountService;
		
	//	quick and dirty: inject user service (use constructor injection)
	@Autowired
	public UserAccountRestController(IUserAccountService iUserAccountService)
	{
		this.iUserAccountService = iUserAccountService;
	}
	
	//  pojo to json
	//	expose "api/users/" and return list of users 
	
	@GetMapping("")
	public List<UserAccount> findAll()
	{
		return iUserAccountService.findAll();
	}

	//	add mapping for GET api/users/{userId}
	@GetMapping("{userId}") //userId parameter
	public UserAccount findById(@PathVariable Long userId)
	{
		UserAccount userAccount = iUserAccountService.findById(userId);
		if(userAccount == null)
			throw new NotFoundException("user id is not found - " + userId);
		return userAccount;
	}
	
	//	add mapping for POST "api/users" - add new user
	@PostMapping("")
	public UserAccount save(@RequestBody UserAccount userAccount) 
	{		
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		userAccount.setId(0L);
		iUserAccountService.saveOrUpdate(userAccount);
		return userAccount;
	}

	//	add mapping for DELETE api/users/{userId} - delete user
	@DeleteMapping({"{userId}"})
	public String delete(@PathVariable Long userId)
	{
		UserAccount userAccount = iUserAccountService.findById(userId);
		if(userAccount == null) //throw exception if null
		{
			throw new NotFoundException("UserId " + userId +  " do not match. ");
		}
		iUserAccountService.deleteById(userId);
		
		return "User with userId '" + userId + "' has been deleted.";
	}

	//	add mapping for PUT api/users/{username/{phone} - update the user
	@PutMapping("/")
	public UserAccount updateProduct(@RequestBody UserAccount userAccount) 
	{		
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		iUserAccountService.saveOrUpdate(userAccount);
		return userAccount;
	}

}
