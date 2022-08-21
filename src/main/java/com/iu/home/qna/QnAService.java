package com.iu.home.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnAService {
	
	@Autowired
	private QnADAO qnaDAO;
	
	public List<QnADTO> getList()throws Exception{
		return qnaDAO.getList();
	}

}
