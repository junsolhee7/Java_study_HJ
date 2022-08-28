package com.iu.home.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.bankMembers.BankMembersFileDTO;
import com.iu.home.board.impl.BoardDAO;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.home.board.notice.NoticeDAO.";
	
	
	public NoticeFileDTO getNum(NoticeFileDTO noticeFileDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNum",noticeFileDTO);
	}
	
	public int setAddFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", noticeFileDTO);
	}     
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	@Override
	public Long getCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}
}
