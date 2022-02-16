package com.kjh.ch05ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		//�������̽��� ��ü�� �����ϸ� �ڹ� �������� ���� ���� �̸� ������ ��� ��ü�� �͵� ��
		//xml���� Pencil6BWithEraserŬ������ ��ü�� ���� ����
		//Pencil.class�� �������̽���.class�� ��
		//���� Pencil4B�� ���� xml���� ����� pencil��ü�� Pencil4B��ü�� ��
		
		pencil.use();
		
		ctx.close();

	}

}
