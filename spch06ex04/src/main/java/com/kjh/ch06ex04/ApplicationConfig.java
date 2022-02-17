package com.kjh.ch06ex04;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCTX.xml")
//@ImportResource어노테이션은 스프링컨테이너설정 xml사용을 처리해줌
public class ApplicationConfig {
	
	@Bean //스프링 콘테이너의 bean을 만드는 어노테이션
	//메서드는 bean의 클래스를 리턴타입으로(Student) 하고 메서드 이름은 bean이름(student1)
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		Student student = new Student("홍길동", 20, hobbys); //생성자로 속성을 설정
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
}
