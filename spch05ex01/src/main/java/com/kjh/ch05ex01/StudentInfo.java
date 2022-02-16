package com.kjh.ch05ex01;

public class StudentInfo {
	private Student student; //이 클래스는 Student클래스에 의존(주입)

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
	
	//setter, getter가 아닌 메서드
	
	public void getStudentInfo() {
		if(student != null) {
			System.out.println("이름 : " + student.getName());
			System.out.println("나이 : " + student.getAge());
			System.out.println("학년 : " + student.getGradeNum());
			System.out.println("반 : " + student.getClassNum());
			System.out.println("====================");
		}
	}
}
