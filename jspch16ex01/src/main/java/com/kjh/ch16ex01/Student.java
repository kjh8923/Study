package com.kjh.ch16ex01;

//jsp���� bean���� ����� ������ Ŭ����
public class Student {
	//�������(�Ӽ�)
	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	//�⺻ ������
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//��� ��������� �Ķ��Ÿ�� ����ϴ� ������
	public Student(String name, int age, int grade, int studentNum) {
		super();
		//this�� �Ķ��Ÿ �̸��� ������� �̸��� �����ϹǷ� ���
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNum = studentNum;
	}
	
	//get, set �޼���
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
}
