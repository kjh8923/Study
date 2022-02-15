package com.kjh.jspMVC.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.jspMVC.dao.BDao;
import com.kjh.jspMVC.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		//�Խ��� ���ڵ���� db���� select�ϰ� dao���� �� ���ڵ�� BDto��ü�� ��ȯ�Ѵ� �̰͵��� ArrayList�� �����Ͽ� ��ȯ 
		ArrayList<BDto> dtos = dao.list();
		//db���� ������ dtos�� list.jsp���� ����ϵ��� request ��ü�� ����
		request.setAttribute("list", dtos);
		//request��ü�� list��� �Ӽ��� dtos���� ����

	}

}
