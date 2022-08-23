package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.impl.BoardDTO;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList() throws Exception{
		return qnaDAO.getList();
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
