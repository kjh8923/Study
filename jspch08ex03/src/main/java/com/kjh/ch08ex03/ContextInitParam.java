package com.kjh.ch08ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInitParam
 */
@WebServlet("/CIP")
public class ContextInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextInitParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		String id = this.getServletContext().getInitParameter("id");
		//getServletContext()�޼���� HttpServletŬ������ ����� ���� ����� ���귿������ ��� �� �� �ִ� �޼���� ��ȯ�� ServletContext ��ü�� ��ȯ��
		//ServletContext��ü�� �ִ� getInitParameter("�Ķ��Ÿ �̸�") �޼���� web.xml�� ������ <context-param>�� �ش� �Ķ��Ÿ ���� ��ȯ
		String pw = this.getServletContext().getInitParameter("pw");
		String path = this.getServletContext().getInitParameter("path");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("path : " + path);
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //Ŭ���̾�Ʈ�� ���� ���� ���� ó���� UTF-8�� ó��
		doGet(request, response);
	}

}
