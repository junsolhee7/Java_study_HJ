package com.iu.home.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	
	@Autowired
	private BankBookService bankBookService;
	
	@PostMapping("commentUpdate")
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		int result= bankBookService.setCommentDelete(bankBookCommentDTO);
		return result;
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{	
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		return result;
	}
	
//	//1. JSP에 출력하고 결과물을 응답으로 전송
//	@GetMapping("commentList")
//	public ModelAndView getCommentList(CommentPager commentPager) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList",ar);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//	}
	//2. JSP에 출력하고 결과물을 응답으로 전송
	@GetMapping("commentList")
	@ResponseBody
	public Map<String,Object> getCommentList(CommentPager commentPager) throws Exception{
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		
		//json
		//DTO == {}
		//num=1 == {"num":1, "bookNum":123, "writer" : "name"}
		//[{dto},{dto},{dto},{dto},{dto}]
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		return map;
	}
	
	
	
	@PostMapping("commentAdd")
	@ResponseBody
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);

		String jsonResult ="{\"result\":\""+result+"\"}";
		
		return jsonResult;
	}
		
	//----------------------------------------------------
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail");
		System.out.println("bookNum:"+ bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
	}
	
	// /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("add get 실행");
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO,ModelAndView mv) throws Exception {
		System.out.println("Add post 실행");

		int result = bankBookService.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		mv.setViewName("redirect:./list.iu");
		//등록 후 list 페이지로 이동
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model) throws Exception {
		System.out.println("Update 폼");
		System.out.println("번호:"+bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("update", bankBookDTO);

	}
	
	@RequestMapping(value = "update.iu" , method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("Update 전송");

		int result = bankBookService.setUpdate(bankBookDTO);
		System.out.println(result==1);

		mv.setViewName("redirect:./detail.iu?bookNum="+bankBookDTO.getBookNum());
		
		return mv;
	}
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("삭제");

		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
		
	}

}
