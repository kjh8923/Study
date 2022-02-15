package com.kjh.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.jspMVC.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//WriteForm.jsp�� form���� �Է��� ������ �˾Ƴ��� dbó�� dao�� ����
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//BDao Ŭ������ write�� ó���ϴ� �޼��带 ȣ��
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
