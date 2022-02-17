package com.kjh.ch07ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName()); //홍길순
		System.out.println("나이 : " + student1.getAge()); //30
		
		System.out.println("===========================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("홍길자");
		student2.setAge(100);
		
		//student2 객체로 변경 했으나 student1도 변경됨
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("===========================");
		
		//scope가 singleton이므로 하나의 동일한 bean으로 만든 자바객체는 모두 동일
		
		if(student1.equals(student2))
			System.out.println("student1 == student2");
		else
			System.out.println("student1 !== student2");
	}
}
