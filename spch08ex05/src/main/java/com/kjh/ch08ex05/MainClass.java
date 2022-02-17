package com.kjh.ch08ex05;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in); //Ű���� �Է°��� �ܼ�â���� ó��
		String str = scanner.next(); //�Էµ� ���� ��ȯ
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
		//AnnotationConfigApplicationContext�ô� ctx.load()�� �ƴ� ctx.register()�� ���
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	}

}
