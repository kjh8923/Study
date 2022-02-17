package com.kjh.ch08ex05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") //��Ȳ�� ���� �Ӽ� ���� ó�� ������̼�
//xml�� profile="dev" ����
public class ApplicationConfigDev {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		return info;
	}
}
