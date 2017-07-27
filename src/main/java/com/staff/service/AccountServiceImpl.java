package com.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.dao.AccountDAO;
import com.staff.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return accountDAO.selectAll();
	}

	public Integer insert(Account t) {
		// TODO Auto-generated method stub
		return accountDAO.insert(t);
	}

	public Integer update(Account t) {
		// TODO Auto-generated method stub
		return accountDAO.update(t);
	}

	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return accountDAO.delete(id);
	}

	public Integer login(Account account) {
		// TODO Auto-generated method stub
		return accountDAO.login(account);
	}

	public String selectById(Integer id) {
		// TODO Auto-generated method stub
		return accountDAO.selectById(id);
	}

	public List<Integer> selectName(String name) {
		// TODO Auto-generated method stub
		return accountDAO.selectName(name);
	}


}
