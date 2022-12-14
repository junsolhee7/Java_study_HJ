package com.iu.home.bankMembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankAccount.BankAccountDTO;
import com.iu.home.bankAccount.BankAccountService;

@Controller
@RequestMapping(value="/member/*")
public class MembersController {

	@Autowired
	private BankMembersService bankMembersService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	
	@RequestMapping(value="myPage.iu", method=RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String,Object> map = bankMembersService.getMyPage(bankMembersDTO);
//		mv.addObject("map",map);
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
//		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
//		
//		mv.addObject("list",ar);
		mv.addObject("dto",bankMembersDTO);
		
		mv.setViewName("member/myPage");
		return mv;
	}
	
	
	@RequestMapping(value="agree", method=RequestMethod.GET)
	public String getAgree() {
		System.out.println("agree GET 실행");
		return "member/agree";
	}
	@RequestMapping(value="agree", method=RequestMethod.POST)
	public String agree() {
		System.out.println("Agree Post 실행");
		return "member/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO,MultipartFile photo,HttpSession session) throws Exception{
		System.out.println("join POST 실행");
		System.out.println("upload 파일명 : " + photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : " + photo.getName());
		System.out.println("upload 파일 크기"+ photo.getSize());
		
		int result = bankMembersService.setJoin(bankMembersDTO,photo,session.getServletContext());
		
		return "member/join";
	}

	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, BankMembersDTO bankMembersDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		
		int result = 0;
		String message = "로그인실패";
		String url = "./login";
		if(bankMembersDTO!=null) {
			result=1;
			message="로그인성공";
			url="../";
		}
		mv.addObject("result",result);
		mv.addObject("message",message);
		mv.addObject("url",url);
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public void getSearchByID()throws Exception{
		
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception{
		List<BankMembersDTO> ar= bankMembersService.getSearchByID(search);
		
		model.addAttribute("list", ar);
		System.out.println(ar);
		return "member/list";
	}
	
}
