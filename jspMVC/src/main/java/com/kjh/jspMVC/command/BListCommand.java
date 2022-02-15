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
		//게시판 레코드들을 db에서 select하고 dao에서 각 레코드는 BDto객체로 변환한다 이것들을 ArrayList에 저장하여 반환 
		ArrayList<BDto> dtos = dao.list();
		//db에서 가져온 dtos를 list.jsp에서 사용하도록 request 객체에 저장
		request.setAttribute("list", dtos);
		//request객체의 list라는 속성에 dtos값을 설정

	}

}
