package com.kjh.ch03ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//���� java ���
		
		/*
		 * MyCalcultor myCalcultor = new MyCalcultor(); myCalcultor.setCalculator(new
		 * Calculator()); myCalcultor.setFirstNum(10); myCalcultor.setSecondNum(2);
		 * myCalcultor.add();
		 */
		
		/*---------------------------------------------------------------------------------------*/
		
		//IOC�����̳ʿ��� ���� ��ü�� ���Թ޾� ����ϴ� ���
		
		//spring ���� ������ ��ġ�� ���ڿ��� ����
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext��� �߻�Ŭ������ ������ GenericXmlApplicationContext Ŭ����
		//spring �����̳��� �������� xml�� ������ �ε��ϴ� ��ü
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		//getBean("bean�̸�", class��)
		myCalculator.add();
	}

}
