package com.kjh.ch08ex05;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		//AnnotationConfigApplicationContext시는 ctx.load()가 아닌 ctx.register()를 사용
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	}

}
