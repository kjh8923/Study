package com.kjh.jspMVC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.jspMVC.command.BCommand;
import com.kjh.jspMVC.command.BListCommand;
import com.kjh.jspMVC.command.BWriteCommand;


/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
//확장자 .do를 사용하는 frontcontroller 서브렛
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BCommand command;
       
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
		System.out.println(com);
		
		if(com.equals("/")) {
			System.out.println("context path입니다.");
			viewPage = "WriteForm.jsp"; //MVC의 view 페이지
		}
		else if(com.equals("/write.do")) {
			System.out.println("write.do 요청입니다.");
			//WriteForm.jsp에서 입력한 게시판 작성 내용을 처리
			command = new BWriteCommand();
			//각각의 일을 처리하는 command중 해당 command객체를 만듦
			command.execute(request, response);
			//command의 일을 처리하는 메서드 execute(request, response) 호출
			//게시판 작성이 끝나면 게시판 목록창을 처리
			viewPage = "list.do";
		}
		else if(com.equals("/list.do")) {
			System.out.println("list.do 요청입니다.");
			//list.do요청은 게시판 리스트창을 구현(게시판의 레코드들을 가져와서 view인 list.jsp페이지를 구성)
			command = new BListCommand();
			command.execute(request, response);
			//request객체에 db의 resultSet을 변환한 ArrayList객체 list가 추가되어 있음
			//list.jsp페이지로 페이지이동 요청은 request작업이므로 list.jsp에서 request객체를 사용하여 db의 레코드 resultSet값을 반영 
			viewPage = "list.jsp";
		}
		else if(com.equals("/writeFormView.do")) {
			System.out.println("writeFormView.do 요청입니다.");
			viewPage = "WriteForm.jsp";
		}
		
		//view 페이지로 페이지 이동
		if(viewPage == null) {
			System.out.println("viewPage가 없습니다.");
		}
		else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); //MVC의 view페이지로 이동
		}
	}

}
