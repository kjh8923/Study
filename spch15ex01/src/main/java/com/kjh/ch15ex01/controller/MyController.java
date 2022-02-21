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
		// 메서드의 파라메타가 dto클래스 이면 dto 클래스 객체가 리턴페이지에 추가돼 리턴페이지에서 EL로 객체.속성 으로 직접 사용 가능
		// BindingResult는 에러내용을 전달하는 Errors 인터페이스 상속 인터페이스
		String page = "createDonePage";
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);	//student객체에 대해 에러체크하고 에러 내용을 result에 전달
		if(result.hasErrors()) {
			page = "formPage";
		}		
		return page;
	}
}
