package com.kjh.jspMVC.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
//확장자 .do를 사용하는 frontcontroller 서브렛
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8"); //post시 한글처리, get은 server에서 설정 함
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");
		String viewPage = null; //이동할 jsp페이지
		
		String uri = request.getRequestURI(); //port번호 이후의 경로(콘텍스트 패스 부터 마지막까지 경로)
		String conPath = request.getContextPath(); //콘텍스트 패스
		String com = uri.substring(conPath.length()); //콘텍스트패스를 제외한 경로 실제 / xxx.do
	}

}
