package com.kjh.ch05ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		//studentInfo bean�� student1 bean�� �����ϰ� ����
		studentInfo.getStudentInfo();
		
		//student2 bean�� student2��ü�� ���
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2); //StudentInfoŬ������ student������� ���� student2
		//bean���� student�� student1���� �Ȱ��� student2�� ����
		studentInfo.getStudentInfo(); //student2 ��ü�� ���� ���
		
		ctx.close();

	}

}
