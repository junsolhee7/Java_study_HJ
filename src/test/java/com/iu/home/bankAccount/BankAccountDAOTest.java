package com.iu.home.bankAccount;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.bankMembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getLisTest()throws Exception{
		BankMembersDTO bankMembersDTO= new BankMembersDTO();
		bankMembersDTO.setUserName("제이스");
		List(BankAccountDTO> ar = bankkAccountDAO.getListByUserName(bankMembersDTO));
		assertNotEquals(0,ar.size());
		
	}
}
