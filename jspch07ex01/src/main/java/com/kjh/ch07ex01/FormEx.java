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
//@WebServlet�� ��û��ο��� /�� ���
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
		//Get����� �ѱ�ó���� tomcat�������� ó��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : kjh");
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("doPost");
		//post����� �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		//request��ü�� ���������� ��û�� ����� ��ü
		//request.getParameter("html form�� name�Ӽ���");�� �ش� name������Ʈ�� �Էµ� ��
		String id = request.getParameter("id"); //id�� form���� name="id"
		String pw = request.getParameter("pw");
		//checkbox�� �������� �����ϹǷ� request.getParameterValues("�Ӽ���")�� ����ϰ�
		//��ȯ�Ǵ� ���� ���ڿ� �迭�̴�
		String[] hobbys = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("��� : " + Arrays.toString(hobbys) + "<br/>");
		//Arrays.toString(�迭)�� �迭�� ���ڿ��� ��ȯ�ϴ� �޼���
		writer.println("���� : " + major + "<br/>");
		writer.println("�������� : " + protocol);
		writer.println("</body></html>");
	}

}
