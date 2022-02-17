package com.kjh.ch07ex01;

import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//스프링컨테이너 생명주기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //스프링컨테이너 생성
		System.out.println("생성");
		
		ctx.load("classpath:applicationCTX.xml"); //설정
		ctx.refresh(); //초기화
		//Student클래스에 추가한 afterPropertiesSet()매서드 자동 호출됨
		//OtherStudent클래스에 추가한 @PostConstruct 자동 실행
		System.out.println("설정과 초기화");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("사용");
		
		ctx.close();
		//Student클래스에 추가한 destroy()메서드 자동 호출
		//OtherStudent클래스에 추가한 @PreDestroy 자동 실행
		System.out.println("소멸");
	}

}
