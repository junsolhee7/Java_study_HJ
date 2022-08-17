package com.iu.home.bankMembers;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.bankMembers.BankMembersDTO;

@Repository
public class BankMembersDAO {
	
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.home.bankMembers.BankMembersDAO.";
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
			
			return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
			
		}
}
