package com.kjh.ch08ex05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") //상황에 따른 속성 선택 처리 어노테이션
//xml의 profile="dev" 역할
public class ApplicationConfigDev {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		return info;
	}
}
