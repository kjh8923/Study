package com.kjh.ch06ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//설정파일 xml을 두개로 만듦
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";
		//생성시 파라메타로 2개 경로 문자열을 사용하면 두개를 포함하는 스프링컨테이너가 생김
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		//메서드의 파라메타가 public void meth(String... resourceLocations)로 된 것은 varargs로 파라메타를 가변으로 처리하라는 의미(파라메타가 여러개 들어와도 된다)
		Student student1 = ctx.getBean("student1", Student.class); // applicationCTX.xml에 정의
		//앞의 student1은 자바에서의 객체명이고 뒤의 student1은 xml에서 bean의 id
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent(); //student2 == student1
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		//student3 빈은 applicationCTX1.xml에 정의됨
		System.out.println(student3.getName());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}
		else {
			System.out.println("student1 !== student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
	}

}
