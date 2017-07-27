package com.staff.dao;


import java.util.List;

import com.staff.entity.Account;

public interface AccountDAO extends BaseDAO<Account>{
	Integer login(Account account);
	String selectById(Integer id);
	List<Integer> selectName(String name);

}
