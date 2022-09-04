package com.iu.home.ApiTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apiTest/*")
public class ApiController {
//	@Autowired
	
	@GetMapping("apiTest")
	public void apiTest() throws Exception{
		
	}

}
