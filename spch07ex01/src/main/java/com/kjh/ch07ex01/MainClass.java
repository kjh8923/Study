package com.kjh.ch07ex01;

import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//�����������̳� �����ֱ�
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //�����������̳� ����
		System.out.println("����");
		
		ctx.load("classpath:applicationCTX.xml"); //����
		ctx.refresh(); //�ʱ�ȭ
		//StudentŬ������ �߰��� afterPropertiesSet()�ż��� �ڵ� ȣ���
		//OtherStudentŬ������ �߰��� @PostConstruct �ڵ� ����
		System.out.println("������ �ʱ�ȭ");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("���");
		
		ctx.close();
		//StudentŬ������ �߰��� destroy()�޼��� �ڵ� ȣ��
		//OtherStudentŬ������ �߰��� @PreDestroy �ڵ� ����
		System.out.println("�Ҹ�");
	}

}
