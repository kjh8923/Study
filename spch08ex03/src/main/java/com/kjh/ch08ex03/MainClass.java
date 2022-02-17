package com.kjh.ch08ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//Annotation�� �̿��� ������ �̿��
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//ApplicationConfigŬ�������� adminConfig bean���� AdminConnection�� ���鵵�� ó��
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		//adminConfig�� bean�̸� AdminConnection.class�� bean�� ����� ��ü
		
		System.out.println("adminId : " + connection.getAdminId());
		System.out.println("adminPw : " + connection.getAdminPw());
		System.out.println("sub_adminId : " + connection.getSub_adminId());
		System.out.println("sub_adminId : " + connection.getSub_adminPw());
		
		ctx.close();
	}

}
