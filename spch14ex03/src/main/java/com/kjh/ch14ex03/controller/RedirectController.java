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
			// redirect:�� ���������� �����ϴ� Ű�����̴�
			// redirect:���� ���� .jsp�� ������ ���� �ƴ�, �� ��û �����
			// redirect:�� servlet�� sendRedirectó�� ����
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk"; // �̶��� studentOk.jsp�� �̵�
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "studentNg";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		return "redirect:http://localhost:8181/ch14ex03/studentURL1.jsp";
		// jsp�� redirect:�� �̵��ô� �����η� jsp���� ����
		// context root�ٷ� �� jsp ��δ� webapp�� ��Ÿ��
	}
}
