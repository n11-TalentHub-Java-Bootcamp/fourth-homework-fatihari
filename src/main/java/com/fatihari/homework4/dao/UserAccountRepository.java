package com.fatihari.homework4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatihari.homework4.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>
{
}
