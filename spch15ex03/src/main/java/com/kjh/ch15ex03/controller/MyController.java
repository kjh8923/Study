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
	// pom.xml에 hibernate와 validation을 사용할 시는 @Valid어노테이션을 사용
	public String create(@ModelAttribute("student") @Valid Student student, BindingResult result) {
		String page = "createDonePage";
		if(result.hasErrors()) {
			page = "formPage";
		}
		return page;
	}
	
	// pom.xml에 hibernate와 validation을 사용할 시는 @InitBinder 구현
	// StudentValidator클래스를 validator로 설정
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
