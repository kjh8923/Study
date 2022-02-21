package com.kjh.ch15ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjh.ch15ex01.dto.Student;
import com.kjh.ch15ex01.util.StudentValidator;

@Controller
public class MyController {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "formPage";
	}
	
	@RequestMapping("/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		// �޼����� �Ķ��Ÿ�� dtoŬ���� �̸� dto Ŭ���� ��ü�� ������������ �߰��� �������������� EL�� ��ü.�Ӽ� ���� ���� ��� ����
		// BindingResult�� ���������� �����ϴ� Errors �������̽� ��� �������̽�
		String page = "createDonePage";
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);	//student��ü�� ���� ����üũ�ϰ� ���� ������ result�� ����
		if(result.hasErrors()) {
			page = "formPage";
		}		
		return page;
	}
}
