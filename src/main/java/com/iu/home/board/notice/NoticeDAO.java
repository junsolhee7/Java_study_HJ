package com.iu.home.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.board.impl.BoardDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.home.board.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail",noticeDTO);
	}
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate",noticeDTO);
	}
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
}
