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
		request.setAttribute("id", "abcde"); //request��ü�� id �Ķ��Ÿ�� abcde�� ����
		request.setAttribute("pw", "12345");
		//setAtrribute()�� ������ ���� getAttribute("�Ӽ���")���� ��ȯ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcherJsp.jsp");
		//request.getRequestDispatcher("�̵������� url")�� RequestDispatcher ��ü�� ����
		dispatcher.forward(request, response);
		//ReausetDispatcher��ü�� forward(request, response)�� ������ �̵�
		//forward�� dispatcherJsp.jsp������ request��ü�� set�� id�� pw�� ����� �� ����
	}

}
