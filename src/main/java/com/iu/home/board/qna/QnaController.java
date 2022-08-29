package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.notice.NoticeDTO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board") //					--(1)
	public String getBoard() {
		return "qna";
	}

	@PostMapping("reply")
	public String setReply(QnaDTO qnaDTO,HttpSession session)throws Exception{
		qnaDTO.setWriter((((BankMembersDTO)(session.getAttribute("member"))).getUserName()));
		int result=qnaService.setReply(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public ModelAndView setReply(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		mv.setViewName("board/reply");
		mv.addObject("qnaDTO",qnaDTO);
		return mv;
		
	}
	
	//글목록
	@RequestMapping(value="list", method=RequestMethod.GET)
//	public ModelAndView getList(@RequestParam(defaultValue="1")Long page) throws Exception{
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager);
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<QnaDTO> ar = qnaService.getList(pager);
		
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("/board/list");

		return mv;
	}

	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView getDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaService.setHitUpdate(qnaDTO);
		qnaDTO = qnaService.getDetail(qnaDTO);
		
		mv.addObject("detail",qnaDTO);
		mv.addObject("board","QnA");
		mv.setViewName("/board/detail");
		return mv;
	}
	
	//글작성
	
		@RequestMapping(value="add", method=RequestMethod.GET)
		public ModelAndView setAdd(ModelAndView mv)throws Exception{

			mv.addObject("board","QnA");
			mv.setViewName("/board/add");
			return mv;
		}
		
		@RequestMapping(value="add", method=RequestMethod.POST)
		public ModelAndView setAdd(QnaDTO qnaDTO, HttpSession session)throws Exception{
			ModelAndView mv = new ModelAndView();
			qnaDTO.setWriter((((BankMembersDTO)(session.getAttribute("member"))).getUserName()));
			int result = qnaService.setAdd(qnaDTO);
			mv.setViewName("redirect:./list");
			return mv;
		}
		
		//글수정
		
		@RequestMapping(value="update.iu",method=RequestMethod.GET)
		public ModelAndView setUpDate(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
			qnaDTO=qnaService.getDetail(qnaDTO);
			mv.addObject("update",qnaDTO);
			mv.addObject("board","QnA");
			mv.setViewName("/board/update");
			return mv;
		}		
		
		@RequestMapping(value="update",method=RequestMethod.POST)
		public String setUpdate(QnaDTO qnaDTO)throws Exception{
			int result = qnaService.setUpdate(qnaDTO);
			
			return "redirect:./detail?num="+qnaDTO.getNum();
		}
		
		//글삭제
		
		@RequestMapping(value="delete",method=RequestMethod.GET)
		public String setDelete (QnaDTO qnaDTO)throws Exception{
			int result = qnaService.setDelete(qnaDTO);

			return "redirect:./list";
		}
	
}
