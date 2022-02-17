package com.kjh.ch06ex04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	//JAVA파일에 XML파일을 포함시켜 사용 하는 방법
	public static void main(String[] args) {
		//java annotation class로 구현한 bean용 스프링컨테이너 생성 클래스 사용
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//어노테이션으로 만든 bean
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		System.out.println("==========================");
		
		//xml로 만든 bean
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		ctx.close();
	}

}
