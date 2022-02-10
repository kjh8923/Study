package com.kjh.ch16ex01;

//jsp에서 bean으로 사용할 데이터 클래스
public class Student {
	//멤버변수(속성)
	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	//기본 생성자
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//모든 멤버변수를 파라메타로 사용하는 생성자
	public Student(String name, int age, int grade, int studentNum) {
		super();
		//this는 파라메타 이름과 멤버변수 이름이 동일하므로 사용
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNum = studentNum;
	}
	
	//get, set 메서드
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
