package com.kjh.ch08ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInit
 */
//@WebServlet("/ServI")
public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		//web.xml���� ������ �Ķ��Ÿ�� GET������� ���޵�
		String id = this.getInitParameter("id");
		//getInitParameter()�޼���� web.xml�� ������ <init-param>�� �Ķ���͸� ��ȯ
		//getInitParameter(�Ķ��Ÿ��)�� �������̽� ServeletConfig�� �޼���� ���귿 Ŭ������ ���� Ŭ��������
		//ServeletConfig�� �����Ͽ����Ƿ� �츮�� ���� ���귿 Ŭ������ �� �޼��带 ����޼���� ������ �־�
		//�ٷ� ��� ����(this�� �� ���귿 ��ü���� �����ϱ� ���� ���)
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");
		
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
		doGet(request, response);
	}

}
