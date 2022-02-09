package com.kjh.ch08ex04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
//ServletContextListener를 구현한 클래스임을 나타내는 어노테이션
//web.xml에 listener등록시는 @WebListener 필요 없음
public class ContextListenerEx implements ServletContextListener {
	
	public ContextListenerEx() {
		//기본형 생성자
	}
	
	//ServletContextListener의 추상메서드 재정의
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}
	
	//ServletContextListener의 추상메서드 재정의
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
