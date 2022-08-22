package com.iu.home.bankAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.bankMembers.BankMembersDTO;

@Repository
public class BankAccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.bankAccount.BankAccountDAO.";
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", bankAccountDTO);
		
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getListByUserName",bankMembersDTO);
	}
	
}
