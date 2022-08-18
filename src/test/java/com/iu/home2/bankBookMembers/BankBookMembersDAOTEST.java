package com.iu.home2.bankBookMembers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.bankMembers.BankMembersDAO;
import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home2.MyAbstractTest;


public class BankBookMembersDAOTEST extends MyAbstractTest{

	@Autowired
	private BankMembersDAO bankMembersDAO;
	private BankMembersDTO bankMembersDTO;
	
//	@Test
//	public void testOfTest1() throws Exception{
//		int i=1;
//		assertEquals(1,i);
//	}
//	@Test
//	public void testOfTest2() throws Exception{
//		int i=1;
//		assertEquals(2,i);
//	}
	
	@Test
	public void setJoinTest() throws Exception{
		bankMembersDTO.setUserName("test");
		bankMembersDTO.setPassWord("test");
		bankMembersDTO.setName("test");
		bankMembersDTO.setEmail("test@test");
		bankMembersDTO.setPhone("test");
		
		/*
		 * int result = bankMembersService.setjoin(bankMembersDTO);
		 * 
		 * assertEquals(1,result);
		 */
	}
	
//	@Test
//	public void getLoginTest() throws Exception{
//		bankMembersDTO.setUserName("test");
//		bankMembersDTO.setUserName("test");
//		bankMembersDTO.setUserName("test");
//		bankMembersDTO.setUserName("test");
//		bankMembersDTO.setUserName("test");
//		bankMembersDAO.getLogin(bankMembersDTO);
//		
//		assertEquals(1,bankMembersDTO);
////		assertNull(obj);
//	}

}
