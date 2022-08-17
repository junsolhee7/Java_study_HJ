package com.iu.home.bankMembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setjoin(bankMembersDTO);
	}

}
