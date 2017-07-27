package com.staff.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Attendance {
	
	private Integer id;
	
	private Integer accountId;
	
	private String accountName;
	
	private Date dateTime;
	
	private java.sql.Timestamp checkInTime;
	
	private java.sql.Timestamp returnTime;
	
	private String remarks;
	
	public Attendance() {
		super();
	}

	public Attendance(Integer id, Integer accountId, String accountName, Date dateTime, Timestamp checkInTime,
			Timestamp returnTime, String remarks) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.accountName = accountName;
		this.dateTime = dateTime;
		this.checkInTime = checkInTime;
		this.returnTime = returnTime;
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public java.sql.Timestamp getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(java.sql.Timestamp checkInTime) {
		this.checkInTime = checkInTime;
	}

	public java.sql.Timestamp getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(java.sql.Timestamp returnTime) {
		this.returnTime = returnTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", accountId=" + accountId + ", accountName=" + accountName + ", dateTime="
				+ dateTime + ", checkInTime=" + checkInTime + ", returnTime=" + returnTime + ", remarks=" + remarks
				+ "]";
	}

}
