package com.kjh.ch07ex01;

import org.springframework.beans.factory.DisposableBean;  //�Ҹ� �������̽�
import org.springframework.beans.factory.InitializingBean; //�ʱ�ȭ �������̽�

//bean���� ���Ǵ� Ŭ������ �ʱ�ȭ�� �Ҹ�ÿ� ó���ϴ� �������̽��� ���� 
public class Student implements InitializingBean, DisposableBean{
	private String name;
	private int age;
	
	public Student() {
		super();
	}

	public Student(String name, int age) {
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
	
	//�����ϴ� �������̽��� �߻�޼��带 ����
	@Override
	public void destroy() throws Exception {
		//DisposableBean�� �߻�޼���
		System.out.println("destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean�� �߻�޼���
		System.out.println("afterPropertiesSet()");	
	}
}
