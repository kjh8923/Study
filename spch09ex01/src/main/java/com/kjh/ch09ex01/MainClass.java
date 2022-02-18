package com.kjh.ch09ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//com.kjh.ch09ex01패키지 내의 모든 메서드가 포인트컷임
//단 개발자가 만든 메서드만 해당(java등의 api제공 메서드는 아님)
public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		//getBean 메서드는 자바 API의 메서드이므로 pointcut이 될 수 없음
		student.getStudentInfo(); //pointcut
		//getStudentInfo()는 개발자가 만든 메서드 이므로 pointcut이 될 수 있음
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //pointcut
		//getWorkerInfo()도 개발자가 만든 메서드 이므로 pointcut이 될 수 있음
		ctx.close();
	}

}
