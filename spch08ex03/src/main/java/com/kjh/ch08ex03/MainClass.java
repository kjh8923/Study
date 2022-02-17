package com.kjh.ch08ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//Annotation을 이용한 설정을 이용시
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//ApplicationConfig클래스에서 adminConfig bean으로 AdminConnection을 만들도록 처리
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		//adminConfig는 bean이름 AdminConnection.class는 bean이 만드는 객체
		
		System.out.println("adminId : " + connection.getAdminId());
		System.out.println("adminPw : " + connection.getAdminPw());
		System.out.println("sub_adminId : " + connection.getSub_adminId());
		System.out.println("sub_adminId : " + connection.getSub_adminPw());
		
		ctx.close();
	}

}
