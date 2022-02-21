package com.kjh.ch14ex03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
			// redirect:은 스프링에서 제공하는 키워드이다
			// redirect:값의 값은 .jsp가 생략된 것이 아님, 즉 요청 경로임
			// redirect:는 servlet의 sendRedirect처럼 동작
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk"; // 이때는 studentOk.jsp로 이동
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "studentNg";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		return "redirect:http://localhost:8181/ch14ex03/studentURL1.jsp";
		// jsp로 redirect:로 이동시는 절대경로로 jsp파일 지정
		// context root바로 밑 jsp 경로는 webapp을 나타냄
	}
}
