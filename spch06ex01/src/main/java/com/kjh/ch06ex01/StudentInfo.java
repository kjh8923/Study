package com.kjh.ch06ex01;

//Student ��ü�� �����ϴ� Ŭ����
//bean���� Ȱ��
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
