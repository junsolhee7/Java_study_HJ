package com.iu.home.bankMembers;

import java.util.List;

import com.iu.home.bankAccount.BankAccountDTO;

public class BankMembersDTO {
	private String userName;
	private String passWord;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTO;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<BankAccountDTO> getBankAccountDTO() {
		return bankAccountDTO;
	}
	public void setBankAccountDTO(List<BankAccountDTO> bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}
	

	
	
	

	
	
	
	

}
