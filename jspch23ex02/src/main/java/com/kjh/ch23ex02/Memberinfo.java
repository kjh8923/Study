package com.kjh.ch23ex02;

//������ Ŭ����(BeanŬ����)
public class Memberinfo {
	//�������(�Ӽ�)
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
