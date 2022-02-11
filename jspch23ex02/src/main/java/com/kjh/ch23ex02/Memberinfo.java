package com.kjh.ch23ex02;

//데이터 클래스(Bean클래스)
public class Memberinfo {
	//멤버변수(속성)
	private String name;
	private String id;
	private String pw;
	
	public Memberinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Memberinfo(String name, String id, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
