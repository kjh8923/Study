package com.kjh.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������Ʈ���� �������̽��� �߻�޼���� �ϳ��� �־ ���
public interface BCommand {
	
	//BCommand �������̽��� �߻�޼���
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
