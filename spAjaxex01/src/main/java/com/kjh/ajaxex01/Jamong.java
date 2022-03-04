package com.kjh.ajaxex01;

//클라이언트의 파라메터와 매핑하는 데이터 클래스
public class Jamong {
	private String name;
	private int age;
	
	public Jamong() {
		super();
	}

	public Jamong(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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
}
