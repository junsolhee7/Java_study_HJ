package com.iu.home.bankMembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/*")
public class MembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
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
}
