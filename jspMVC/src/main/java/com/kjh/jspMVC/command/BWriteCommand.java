package com.kjh.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//내용 부분이 없어도 인터페이스를 구현한거로 간주
		//향후에 BWriteCommand가 수행 할 프로그램 처리를 여기서 구현
	}

}
