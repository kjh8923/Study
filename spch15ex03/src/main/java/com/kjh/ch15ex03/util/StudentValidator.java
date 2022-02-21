package com.kjh.ch15ex03.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kjh.ch15ex03.dto.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		//return false;
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)target;
		String studentName = student.getName();
		
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); 	//에러 내용을 저장
		}
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		//위의 null이나 empty체크시 대신 사용 가능(int 체크는 안됨)
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}
}