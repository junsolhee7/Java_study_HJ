package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception{
		
		List<QnaDTO> ar = qnaService.getList();
		model.addAttribute("list", ar);
		
		return "board/qna/list";
	}
}
