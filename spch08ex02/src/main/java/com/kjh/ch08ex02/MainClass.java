package com.kjh.ch08ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("adminId : " + connection.getAdminId());
		System.out.println("adminPw : " + connection.getAdminPw());
		System.out.println("sub_adminId : " + connection.getSub_adminId());
		System.out.println("sub_adminId : " + connection.getSub_adminPw());
		
		ctx.close();

	}

}
