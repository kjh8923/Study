package com.kjh.ch05ex01;

public class StudentInfo {
	private Student student; //�� Ŭ������ StudentŬ������ ����(����)

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
	
	//setter, getter�� �ƴ� �޼���
	
	public void getStudentInfo() {
		if(student != null) {
			System.out.println("�̸� : " + student.getName());
			System.out.println("���� : " + student.getAge());
			System.out.println("�г� : " + student.getGradeNum());
			System.out.println("�� : " + student.getClassNum());
			System.out.println("====================");
		}
	}
}
