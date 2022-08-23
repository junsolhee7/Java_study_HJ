package com.iu.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnADTO;

@Controller
@RequestMapping(value="/board/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list",ar);
		return "/board/notice/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.setViewName("board/notice/detail");
		mv.addObject("detail",noticeDTO);
		return mv;
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model)throws Exception{
		noticeDTO=noticeService.getDetail(noticeDTO);
		model.addAttribute("update",noticeDTO);
	}

	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		noticeService.setUpdate(noticeDTO);
		mv.setViewName("redirect:./detail?num="+noticeDTO.getNum());
		return mv;
	}
}
