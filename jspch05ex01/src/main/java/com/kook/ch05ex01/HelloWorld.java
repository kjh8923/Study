package com.kook.ch05ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HW")
//@WebServlet은 어노테이션으로 기능을 가진 주석으로 URL매핑을 처리 해준다.
//@WebServlet을 사용하지 않으려면 web.xml에 url매핑을 해준다.
public class HelloWorld extends HttpServlet {
	//servlet 역할의 클래스는 HttpServlet추상 클래스를 상속해서 만듦
	//HttpServlet -> GenericServlet(추상클래스) -> Servlet(인터페이스)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() { //기본형 생성자
        super(); //상위 클래스인 HttpServlet의 생성자
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //클라이언트에서 요청시 get방식이면 서브렛에서 실행해야 할 메서드
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld~");
		
		response.setContentType("text/html; charset=UTF-8");
		//응답(브라우저로 전달) 될 컨테츠는 문자로된 html이고 문자를 UTF-8방식을 지정
		PrintWriter writer = response.getWriter();
		//PrintWriter는 출력을 처리하는 객체
		//서브렛에서는 html문서를 PrintWriter객체의 println()메서드로 만들어줌
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>HelloWorld~~~</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
