package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList(Pager pager) throws Exception{
		Long totalCount=qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		return qnaDAO.getList(pager);
	}
	public Long getCount(Pager pager)throws Exception{
		return qnaDAO.getCount(pager);
	}
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.getDetail(qnaDTO);
	}

	public int setAdd(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.setAdd(qnaDTO);
	}

	public int setUpdate(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.setUpdate(qnaDTO);
	}

	public int setDelete(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.setDelete(qnaDTO);
	}

	
}
