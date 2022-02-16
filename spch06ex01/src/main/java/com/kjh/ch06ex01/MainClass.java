package com.kjh.ch06ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//�������� xml�� �ΰ��� ����
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";
		//������ �Ķ��Ÿ�� 2�� ��� ���ڿ��� ����ϸ� �ΰ��� �����ϴ� �����������̳ʰ� ����
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		//�޼����� �Ķ��Ÿ�� public void meth(String... resourceLocations)�� �� ���� varargs�� �Ķ��Ÿ�� �������� ó���϶�� �ǹ�(�Ķ��Ÿ�� ������ ���͵� �ȴ�)
		Student student1 = ctx.getBean("student1", Student.class); // applicationCTX.xml�� ����
		//���� student1�� �ڹٿ����� ��ü���̰� ���� student1�� xml���� bean�� id
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent(); //student2 == student1
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		//student3 ���� applicationCTX1.xml�� ���ǵ�
		System.out.println(student3.getName());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}
		else {
			System.out.println("student1 !== student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
	}

}
