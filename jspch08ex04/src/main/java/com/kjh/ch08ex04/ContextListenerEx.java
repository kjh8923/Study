package com.kjh.ch08ex04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
//ServletContextListener�� ������ Ŭ�������� ��Ÿ���� ������̼�
//web.xml�� listener��Ͻô� @WebListener �ʿ� ����
public class ContextListenerEx implements ServletContextListener {
	
	public ContextListenerEx() {
		//�⺻�� ������
	}
	
	//ServletContextListener�� �߻�޼��� ������
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}
	
	//ServletContextListener�� �߻�޼��� ������
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
