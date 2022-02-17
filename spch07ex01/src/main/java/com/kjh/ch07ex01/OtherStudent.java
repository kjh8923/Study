package com.kjh.ch07ex01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	public OtherStudent() {
		super();
	}

	public OtherStudent(String name, int age) {
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
	
	//������̼����� ���� �� �߰� �۾� �޼���� �Ҹ��� �߰� �۾��� ó��
	//������̼� @PostConstruct�� @PreDestroy�� ���
	//applicationCTX.xml�� <context:annotation-config/> �߰��ؾ� ��� ����
	//���귿������ ���
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
}
