package com.kjh.ch05ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		//인터페이스의 객체로 생성하면 자바 다형성에 의해 값은 이를 구현한 어느 객체가 와도 됨
		//xml에서 Pencil6BWithEraser클래스의 객체로 빈을 만듦
		//Pencil.class는 인터페이스명.class로 함
		//만일 Pencil4B용 빈을 xml에서 만들면 pencil객체는 Pencil4B객체가 됨
		
		pencil.use();
		
		ctx.close();

	}

}
