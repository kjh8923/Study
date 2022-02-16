package com.kjh.ch05ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		//studentInfo bean은 student1 bean에 의존하고 있음
		studentInfo.getStudentInfo();
		
		//student2 bean을 student2객체로 사용
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2); //StudentInfo클래스의 student멤버변수 값이 student2
		//bean에서 student가 student1으로 된것을 student2로 변경
		studentInfo.getStudentInfo(); //student2 객체의 값을 출력
		
		ctx.close();

	}

}
