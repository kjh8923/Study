package com.kjh.ch06ex04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	//JAVA���Ͽ� XML������ ���Խ��� ��� �ϴ� ���
	public static void main(String[] args) {
		//java annotation class�� ������ bean�� �����������̳� ���� Ŭ���� ���
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//������̼����� ���� bean
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("���� : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		System.out.println("==========================");
		
		//xml�� ���� bean
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("���� : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}
