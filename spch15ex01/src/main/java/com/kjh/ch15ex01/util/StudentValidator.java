package com.kjh.ch15ex01.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kjh.ch15ex01.dto.Student;

// 에러를 체크하는 클래스로 에러체크 인터페이스 Validator를 구현
public class StudentValidator implements Validator{
	//인터페이스 Validator의 추상메서드 구현
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) { 	// 실제 student의 멤버변수를 검증해주는 메서드 구현
		//Errors errors 객체는 에러내용을 저장할 객체
		System.out.println("validate()");
		Student student = (Student)target;
		String studentName = student.getName();
		/*
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); 	//에러 내용을 저장
		}
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		//위의 null이나 empty체크시 대신 사용 가능(int 체크는 안됨)
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}	
}
