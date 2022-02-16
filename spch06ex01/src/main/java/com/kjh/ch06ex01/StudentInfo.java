package com.kjh.ch06ex01;

//Student 객체에 의존하는 클래스
//bean으로 활용
public class StudentInfo {
	private Student student;

	public StudentInfo() {
		super();
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
