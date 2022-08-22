package com.iu.home.bankMembers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
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
	
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() {
		System.out.println("join GET 실행");
		return "member/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("join POST 실행");
		int result = bankMembersService.setJoin(bankMembersDTO);
		
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
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		
		return "redirect:../";
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
