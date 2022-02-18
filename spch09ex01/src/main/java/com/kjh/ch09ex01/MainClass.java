package com.kjh.ch09ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//com.kjh.ch09ex01��Ű�� ���� ��� �޼��尡 ����Ʈ����
//�� �����ڰ� ���� �޼��常 �ش�(java���� api���� �޼���� �ƴ�)
public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		//getBean �޼���� �ڹ� API�� �޼����̹Ƿ� pointcut�� �� �� ����
		student.getStudentInfo(); //pointcut
		//getStudentInfo()�� �����ڰ� ���� �޼��� �̹Ƿ� pointcut�� �� �� ����
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //pointcut
		//getWorkerInfo()�� �����ڰ� ���� �޼��� �̹Ƿ� pointcut�� �� �� ����
		ctx.close();
	}

}
