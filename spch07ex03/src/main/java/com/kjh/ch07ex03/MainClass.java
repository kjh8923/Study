package com.kjh.ch07ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("�̸� : " + student1.getName()); //ȫ���
		System.out.println("���� : " + student1.getAge()); //30
		
		System.out.println("===========================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("ȫ����");
		student2.setAge(100);
		
		//student2 ��ü�� ���� ������ student1�� �����
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		
		System.out.println("===========================");
		
		//scope�� singleton�̹Ƿ� �ϳ��� ������ bean���� ���� �ڹٰ�ü�� ��� ����
		
		if(student1.equals(student2))
			System.out.println("student1 == student2");
		else
			System.out.println("student1 !== student2");
	}
}
