package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.util.Pager;

@Repository
public class QnaDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.board.qna.QnaDAO.";
	
	public Long getCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}
	
	public List<QnaDTO> getList(Pager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail",qnaDTO);
	}
	
	public int setAdd(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", qnaDTO);
	}
	
	public int setUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", qnaDTO);
	}

	public int setDelete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", qnaDTO);
	}

	public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setReplyAdd",qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setStepUpdate",qnaDTO);
	}
	
	public int setHitUpdate(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setHitUpdate",qnaDTO);
	}
}
