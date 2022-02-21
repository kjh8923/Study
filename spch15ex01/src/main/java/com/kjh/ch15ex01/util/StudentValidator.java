package com.kjh.ch15ex01.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kjh.ch15ex01.dto.Student;

// ������ üũ�ϴ� Ŭ������ ����üũ �������̽� Validator�� ����
public class StudentValidator implements Validator{
	//�������̽� Validator�� �߻�޼��� ����
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) { 	// ���� student�� ��������� �������ִ� �޼��� ����
		//Errors errors ��ü�� ���������� ������ ��ü
		System.out.println("validate()");
		Student student = (Student)target;
		String studentName = student.getName();
		/*
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); 	//���� ������ ����
		}
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		//���� null�̳� emptyüũ�� ��� ��� ����(int üũ�� �ȵ�)
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}	
}
