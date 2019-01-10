package com.bank.bean;

import java.io.InputStream;


public class AccountInfoBean {
	int id;
	String  sercretPin;
	String accountType;
	int minBalance;
	int userid;
	private int amount;
	private InputStream bank_share;

	


	public InputStream getBank_share() {
		return bank_share;
	}
	public void setBank_share(InputStream bank_share) {
		this.bank_share = bank_share;
	}
	public String getSecretPin() {
		return sercretPin;
	}

	public void setSecretPin(String SecretPin) {
		this.sercretPin = SecretPin;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}

}
