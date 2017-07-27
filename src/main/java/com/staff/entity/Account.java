package com.staff.entity;

public class Account {
	private Integer id;
	
	private Integer accountNumber;
	
	private String name;
	
	private String password;
	
	private String position;

	public Account() {
		super();
	}

	public Account(Integer id, Integer accountNumber, String name, String password, String position) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", position=" + position + "]";
	}

}
