package com.kjh.ch08ex04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in); //키보드 입력값을 콘솔창에서 처리
		String str = scanner.next(); //입력된 값을 반환
		if(str.equals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		//ConfigurableEnvironment객체를 얻어 xml파일의 profile속성을 찾아 활성화 프로파일 xml파일을 설정
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		//두개 xml에서 활성화된것을 로딩
		//로딩된 xml 파일의 bean을 사용
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	} 

}
