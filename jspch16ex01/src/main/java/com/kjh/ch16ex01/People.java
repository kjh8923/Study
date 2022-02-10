package com.kjh.ch16ex01;

public class People {
	//멤버변수
	private String name;
	private String id;
	private String address;
	private int age;
	
	//기본 생성자
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//모든 멤버변수를 파라메타로 사용하는 생성자
	public People(String name, String id, String address, int age) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.age = age;
	}
	
	//get, set 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
