package com.kjh.ch15ex03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjh.ch15ex03.dto.Student;
import com.kjh.ch15ex03.util.StudentValidator;

@Controller
public class MyController {
	@RequestMapping("/formPage")
	public String formPage() {
		return "formPage";
	}
	
	@RequestMapping("/create")
	// pom.xml�� hibernate�� validation�� ����� �ô� @Valid������̼��� ���
	public String create(@ModelAttribute("student") @Valid Student student, BindingResult result) {
		String page = "createDonePage";
		if(result.hasErrors()) {
			page = "formPage";
		}
		return page;
	}
	
	// pom.xml�� hibernate�� validation�� ����� �ô� @InitBinder ����
	// StudentValidatorŬ������ validator�� ����
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
