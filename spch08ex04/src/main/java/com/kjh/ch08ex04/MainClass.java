package com.kjh.ch08ex04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

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
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		//ConfigurableEnvironment��ü�� ��� xml������ profile�Ӽ��� ã�� Ȱ��ȭ �������� xml������ ����
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		//�ΰ� xml���� Ȱ��ȭ�Ȱ��� �ε�
		//�ε��� xml ������ bean�� ���
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	} 

}
