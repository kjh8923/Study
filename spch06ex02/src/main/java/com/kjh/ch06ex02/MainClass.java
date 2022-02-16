package com.kjh.ch06ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//java annotation @Configuration, @Bean�� �̿��� bean�� ����ϴ� �����������̳ʴ� ���� Ŭ������ ��ü�� �̿�
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		//@Configuration ���Ͽ��� �޼��� �̸��� student1�� ��
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("���� : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		System.out.println("==========================");
		
		Student student2 = ctx.getBean("student2", Student.class);
		//@Configuration ���Ͽ��� �޼��� �̸��� student2�� ��
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("���� : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}
