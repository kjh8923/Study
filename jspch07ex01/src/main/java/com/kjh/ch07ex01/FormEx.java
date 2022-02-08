package com.kjh.ch07ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
//@WebServlet의 요청경로에는 /를 사용
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		//Get방식의 한글처리는 tomcat서버에서 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디 : kjh");
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("doPost");
		//post방식의 한글 처리
		request.setCharacterEncoding("UTF-8");
		//request객체는 브라우저에서 요청시 사용한 객체
		//request.getParameter("html form의 name속성값");는 해당 name엘리먼트에 입력된 값
		String id = request.getParameter("id"); //id는 form에서 name="id"
		String pw = request.getParameter("pw");
		//checkbox는 복수개를 선택하므로 request.getParameterValues("속성명")를 사용하고
		//반환되는 값은 문자열 배열이다
		String[] hobbys = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("취미 : " + Arrays.toString(hobbys) + "<br/>");
		//Arrays.toString(배열)은 배열을 문자열로 변환하는 메서드
		writer.println("전공 : " + major + "<br/>");
		writer.println("프로토콜 : " + protocol);
		writer.println("</body></html>");
	}

}
