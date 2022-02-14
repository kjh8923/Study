package com.kjh.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//프로젝트에서 인터페이스용 추상메서드는 하나만 있어도 충분
public interface BCommand {
	
	//BCommand 인터페이스의 추상메서드
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
