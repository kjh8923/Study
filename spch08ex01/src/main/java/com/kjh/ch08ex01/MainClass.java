package com.kjh.ch08ex01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		
		//ConfigurableApplicationContext 인터페이스는 환경변수설정을 위한 객체를 반환하는 메서드를 제공
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment(); //환경변수설정용 객체를 반환
		MutablePropertySources propertySources = env.getPropertySources(); //스프링컨테이너 bean들의 속성을 처리하는 객체를 얻어냄
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			//ResourcePropertySource는 속성정보를 가진 자원을 처리하는 클래스
			//admin.properties라는 속성용 파일을 객체화하여 propertySources 마지막에 추가
			System.out.println(env.getProperty("admin.id"));
			//getProperty("property이름")으로 속성값을 가져옴
			System.out.println(env.getProperty("admin.pw"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//xml 사용을 위해 형변환
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
