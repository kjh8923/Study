package com.kjh.ch08ex03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	//properties 파일을 사용하기 위해서는 @Value("${프로퍼티스 파일의 키값}") 어노테이션을 사용
	//@Value("${프로퍼티스 파일의 키값}") 어노테이션 밑에 값을 저장할 멤버변수를 선언 
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	@Bean //properties 파일 위치를 등록하고 @Value를 이용하여 properties의 속성을 멤버 변수에 설정 해줌
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2]; //Resuorce클래스객체로 구성되는 크기 2인 배열
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	//@Value로 만들어진 속성값을 AdminConnection객체에 설정
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
