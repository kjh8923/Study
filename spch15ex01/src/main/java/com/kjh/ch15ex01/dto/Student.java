package com.kjh.ch15ex01.dto;

//DTOŬ����
public class Student {
	private String name;
	private int id;  //form�� �Ķ��Ÿ���� ��� String�̳� ���⼭ ������ ������������ �ڵ� ����ȯ �Ǿ ����
	
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
