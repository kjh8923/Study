package com.kjh.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.jspMVC.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//WriteForm.jsp의 form에서 입력한 값들을 알아내어 db처리 dao로 전달
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//BDao 클래스의 write시 처리하는 메서드를 호출
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
