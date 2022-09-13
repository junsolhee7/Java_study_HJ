package com.iu.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.반복문돌려서 admin꺼내기 RoleDTOs에서
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		boolean check=false;
		
		for(RoleDTO roleDTO:bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleName());
			System.out.println(roleDTO.getRoleNum());
			if(roleDTO.getRoleName().equals("ADMIN")) {
				check=true;
				break;
			}
		}
		
		//admin이 아닐때 메시지, index로, "권한이없습니다" (check=false일때), forward방식(jsp)
		if(!check) {
			request.setAttribute("message","권한이 없습니다");
			request.setAttribute("url","../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/common/result.jsp");//jsp의 경로, controlle에서는 prefix,suffix가 생략
			view.forward(request,response);
		}
		
		return check; 
	}
}
