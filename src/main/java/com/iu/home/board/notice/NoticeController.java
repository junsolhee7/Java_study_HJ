package com.iu.home.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.qna.QnaDTO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board") //					--(1)mv.addObject("board","Notice");
	public String getBoard() {
		return "notice";
	}

	//글목록
	@RequestMapping(value="list", method=RequestMethod.GET)
//	public ModelAndView getList(@RequestParam(defaultValue="1")Long page) throws Exception{
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager);
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("/board/list");

		return mv;
	}
	
	//글상세
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("detail",boardDTO);
		
		mv.addObject("board","notice");
		mv.setViewName("/board/detail");
	
		return mv;
	}
	
	//글작성
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView setAdd(ModelAndView mv)throws Exception{
		
		mv.addObject("board","Notice");
		mv.setViewName("/board/add");
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, HttpSession session, MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO.setWriter((((BankMembersDTO)(session.getAttribute("member"))).getUserName()));
		int result = noticeService.setAdd(boardDTO,files,session.getServletContext());
		mv.addObject("dto",boardDTO);
		
		String message="게시글 작성 실패";
		String url = "./add";
		if(result>0) {
			result=1;
			message="게시글 작성 완료";
			url="../list";
		}	
		mv.addObject("result",result);
		mv.addObject("message",message);
		mv.addObject("url","./list");
		
		mv.setViewName("common/result");
		return mv;
	}
	
	//글수정
	
	@RequestMapping(value="update.iu",method=RequestMethod.GET)
	public ModelAndView setUpDate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO=noticeService.getDetail(boardDTO);
		mv.addObject("update",boardDTO);
		mv.addObject("board","Notice");
		mv.setViewName("/board/update");
		return mv;
	}		
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	
	//글삭제
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String setDelete (BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);

		return "redirect:./list";
	}
}
