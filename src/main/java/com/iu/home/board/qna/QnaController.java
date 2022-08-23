package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaDTO = qnaService.getDetail(qnaDTO);
		mv.addObject("detail",qnaDTO);
		mv.setViewName("/board/qna/detail");
		return mv;
	}
	
}
