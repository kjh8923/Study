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
	
	//어노테이션으로 생성 후 추가 작업 메서드와 소멸후 추가 작업을 처리
	//어노테이션 @PostConstruct과 @PreDestroy를 사용
	//applicationCTX.xml에 <context:annotation-config/> 추가해야 사용 가능
	//서브렛에서도 사용
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
}
