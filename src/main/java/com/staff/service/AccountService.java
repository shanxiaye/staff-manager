package com.staff.service;

import java.util.List;

import com.staff.entity.Account;

public interface AccountService extends BaseService<Account>  {
	Integer login(Account account);
	String selectById(Integer id);
	List<Integer> selectName(String name);

}
