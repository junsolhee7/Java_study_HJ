package com.iu.home.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.qna.QnADTO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list",ar);
		return "/notice/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.setViewName("notice/detail");
		mv.addObject("detail",noticeDTO);

		return mv;
	}

}
