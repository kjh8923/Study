package com.kjh.ch07ex01;

import org.springframework.beans.factory.DisposableBean;  //소멸 인터페이스
import org.springframework.beans.factory.InitializingBean; //초기화 인터페이스

//bean으로 사용되는 클래스에 초기화와 소멸시에 처리하는 인터페이스를 구현 
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
	
	//구현하는 인터페이스의 추상메서드를 구현
	@Override
	public void destroy() throws Exception {
		//DisposableBean의 추상메서드
		System.out.println("destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean의 추상메서드
		System.out.println("afterPropertiesSet()");	
	}
}
