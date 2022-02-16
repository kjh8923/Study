package com.kjh.ch06ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//java annotation @Configuration, @Bean을 이용한 bean을 사용하는 스프링컨테이너는 다음 클래스의 객체를 이용
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		//@Configuration 파일에서 메서드 이름이 student1인 빈
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		System.out.println("==========================");
		
		Student student2 = ctx.getBean("student2", Student.class);
		//@Configuration 파일에서 메서드 이름이 student2인 빈
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		ctx.close();
	}

}
