package com.fatihari.homework4.service;

import java.util.List;
import java.util.Optional;

import com.fatihari.homework4.entity.UserAccount;

public interface IUserAccountService 
{
	public List<UserAccount> findAll();
	public UserAccount findById(Long id);
	public UserAccount saveOrUpdate(UserAccount userAccount);
	public void deleteById(Long userId);
}
