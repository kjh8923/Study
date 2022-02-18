package com.kjh.ch06ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//Xml���Ͽ� JAVA������ ���Խ��� ��� �ϴ� ���

public class MainClass {

	public static void main(String[] args) {
		//������ �������� xml���� ������ ��ü
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		//bean�� student1�̹Ƿ� java���� ����
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("���� : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		System.out.println("==========================");
		
		//bean�� student2�̹Ƿ� xml���� ����
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("���� : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}