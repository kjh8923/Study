package com.kjh.ch08ex01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		
		//ConfigurableApplicationContext �������̽��� ȯ�溯�������� ���� ��ü�� ��ȯ�ϴ� �޼��带 ����
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment(); //ȯ�溯�������� ��ü�� ��ȯ
		MutablePropertySources propertySources = env.getPropertySources(); //�����������̳� bean���� �Ӽ��� ó���ϴ� ��ü�� ��
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			//ResourcePropertySource�� �Ӽ������� ���� �ڿ��� ó���ϴ� Ŭ����
			//admin.properties��� �Ӽ��� ������ ��üȭ�Ͽ� propertySources �������� �߰�
			System.out.println(env.getProperty("admin.id"));
			//getProperty("property�̸�")���� �Ӽ����� ������
			System.out.println(env.getProperty("admin.pw"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//xml ����� ���� ����ȯ
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
