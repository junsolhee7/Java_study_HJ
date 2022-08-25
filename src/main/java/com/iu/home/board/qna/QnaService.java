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
	
	
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		return result;
	}
	
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
		System.out.println("Insert전:"+qnaDTO.getNum());
		int result=qnaDAO.setAdd(qnaDTO);
		System.out.println("Insert후:"+qnaDTO.getNum());
		return result;
	}

	public int setUpdate(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.setUpdate(qnaDTO);
	}

	public int setDelete(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.setDelete(qnaDTO);
	}

	
}
