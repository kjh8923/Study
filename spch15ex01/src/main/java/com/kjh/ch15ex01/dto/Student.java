package com.kjh.ch15ex01.dto;

//DTO클래스
public class Student {
	private String name;
	private int id;  //form의 파라메타값은 모두 String이나 여기서 설정한 데이터형으로 자동 형변환 되어서 설정
	
	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
} 
