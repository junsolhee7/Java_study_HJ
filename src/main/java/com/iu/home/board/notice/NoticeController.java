package com.iu.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.qna.QnaDTO;

@Controller
@RequestMapping(value="/board/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	//글목록
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList();
		
		mv.addObject("list",ar);
		mv.setViewName("/board/notice/list");
		return mv;
	}
	
	//글상세
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("detail",boardDTO);
		mv.setViewName("board/notice/detail");
	
		return mv;
	}
	
	//글작성
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/notice/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	//글수정
	
	@RequestMapping(value="update.iu",method=RequestMethod.GET)
	public ModelAndView setUpDate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO=noticeService.getDetail(boardDTO);
		mv.addObject("update",boardDTO);
		mv.setViewName("board/notice/update");
		return mv;
	}		
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	
	//글삭제
	
	public String setDelete (BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);

		return "redirect:./list";
	}
}
