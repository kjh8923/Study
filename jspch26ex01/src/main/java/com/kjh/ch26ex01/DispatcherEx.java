package com.kjh.ch26ex01;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherEx
 */
@WebServlet("/DEX")
public class DispatcherEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherEx() {
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
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setAttribute("id", "abcde"); //request객체에 id 파라메타로 abcde값 설정
		request.setAttribute("pw", "12345");
		//setAtrribute()로 설정한 값은 getAttribute("속성명")으로 반환
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcherJsp.jsp");
		//request.getRequestDispatcher("이동페이지 url")로 RequestDispatcher 객체를 구함
		dispatcher.forward(request, response);
		//ReausetDispatcher객체의 forward(request, response)로 페이지 이동
		//forward된 dispatcherJsp.jsp에서는 request객체에 set된 id와 pw를 사용할 수 있음
	}

}
