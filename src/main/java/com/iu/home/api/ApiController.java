package com.iu.home.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/*")
public class ApiController {
//	@Autowired
	
	@GetMapping("kakao")
	public void kakao() throws Exception{
		
	}
	
	@GetMapping("lol")
	public void lol() throws Exception{
		
	}

}
