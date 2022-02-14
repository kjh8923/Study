package com.kjh.ch25ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.ch25ex01.Command.InsertCommand;
import com.kjh.ch25ex01.Command.MyCommand;
import com.kjh.ch25ex01.Command.UpdateCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
//확장자가 do인 요청은 전부 이 서브렛으로 요청이 옴
//url pattern 만들시 /없이 *.do로 만듦 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MyCommand comm; //command패턴의 커맨드 인터페이스 객체 설정
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");
		//확장자 .do의 모든 요청이 이곳으로 오므로 요청 이름(요청경로명)을 파악하여 각각 처리
		String uri = request.getRequestURI(); //요청 uri는 port번호 이후의 context패스부터의 경로
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath(); //context패스(프로젝트이름) 반환
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length()); //command는 각각의 서브렛 요청 경로
														  // subString(int beginIndex)는 beginIndex색인번호부터 끝까지의 문자열 반환
		System.out.println("command : " + command);
		if(command.equals("/insert.do")) {
			System.out.println("insert");
			System.out.println("-------------");
			comm = new InsertCommand();
			comm.execute();
		}
		else if(command.equals("/update.do")){
			System.out.println("update");
			System.out.println("-------------");
			comm = new UpdateCommand();
			comm.execute();
		}
		else if(command.equals("/select.do")){
			System.out.println("select");
			System.out.println("-------------");
		}
		else if(command.equals("/delete.do")){
			System.out.println("delete");
			System.out.println("-------------");
		}
	}

}
