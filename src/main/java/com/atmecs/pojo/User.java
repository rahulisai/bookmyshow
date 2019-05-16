package com.atmecs.pojo;

public class User {
	private int id;
	private String name;
	private String lname;
	private String choice;
	private int seatcount;
	private double balance;
	private String billprint;
	private double ticketcharge;
	private String loginChoice;
	private String password;
	private String paymentMode;
	private int bankAccount;

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginChoice() {
		return loginChoice;
	}

	public void setLoginChoice(String loginChoice) {
		this.loginChoice = loginChoice;
	}

	public double getTicketcharge() {
		return ticketcharge;
	}

	public void setTicketcharge(double ticketcharge) {
		this.ticketcharge = ticketcharge;
	}

	public String getBillprint() {
		return billprint;
	}

	public void setBillprint(String billprint) {
		this.billprint = billprint;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lname=" + lname + ", choice=" + choice + ", seatcount="
				+ seatcount + "]";
	}

}
