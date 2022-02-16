package com.kjh.ch06ex02;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml대신 bean을 설정해주는 클래스

@Configuration
//@Configuration 어노테이션은 ApplicationConfig클래스가 스프링설정 관련 클래스임을 나타냄
public class ApplicationConfig {
	@Bean
	public Student student1() {
		//리턴타입인 Student는 bean의 클래스명
		//메서드명 student1은 빈의 id
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		Student student = new Student("홍길동", 20, hobbys); //생성자로 속성을 설정
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		//리턴타입인 Student는 bean의 클래스명
		//메서드명 student2는 빈의 id
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악");
		Student student = new Student("홍길자", 25, hobbys); //생성자로 속성을 설정
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
}
