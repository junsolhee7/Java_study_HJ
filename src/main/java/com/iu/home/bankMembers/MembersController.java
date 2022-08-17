package com.iu.home.bankMembers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.home.bankMembers.BankMembersDAO;
import com.iu.home.bankMembers.BankMembersDTO;

@Controller
@RequestMapping(value="/member/*")
public class MembersController {
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join() {
		System.out.println("join get 실행");
		return "member/join";
	}
@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	
//	public String join(HttpServletRequest request) throws Exception{
	public String join(BankMembersDTO bankMembersDTO) throws Exception{
		
		System.out.println("join Post 실행");
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println((bankMembersDTO.getUserName()));
		System.out.println(result==1);
		
		return "redirect:./login.iu";
	}

}
