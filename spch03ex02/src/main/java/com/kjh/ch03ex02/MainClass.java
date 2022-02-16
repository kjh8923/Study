package com.kjh.ch03ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//기존 java 방식
		
		/*
		 * MyCalcultor myCalcultor = new MyCalcultor(); myCalcultor.setCalculator(new
		 * Calculator()); myCalcultor.setFirstNum(10); myCalcultor.setSecondNum(2);
		 * myCalcultor.add();
		 */
		
		/*---------------------------------------------------------------------------------------*/
		
		//IOC컨테이너에서 만든 객체를 주입받아 사용하는 방식
		
		//spring 설정 파일의 위치를 문자열로 지정
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext라는 추상클래스를 구현한 GenericXmlApplicationContext 클래스
		//spring 컨테이너의 설정파일 xml의 내용을 로딩하는 객체
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		//getBean("bean이름", class명)
		myCalculator.add();
	}

}
