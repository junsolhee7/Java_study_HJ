package com.iu.home.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnADAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.qna.QnADAO.";
	
	public List<QnADTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	

}
