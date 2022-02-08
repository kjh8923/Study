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
//@WebServlet�� ������̼����� ����� ���� �ּ����� URL������ ó�� ���ش�.
//@WebServlet�� ������� �������� web.xml�� url������ ���ش�.
public class HelloWorld extends HttpServlet {
	//servlet ������ Ŭ������ HttpServlet�߻� Ŭ������ ����ؼ� ����
	//HttpServlet -> GenericServlet(�߻�Ŭ����) -> Servlet(�������̽�)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() { //�⺻�� ������
        super(); //���� Ŭ������ HttpServlet�� ������
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Ŭ���̾�Ʈ���� ��û�� get����̸� ���귿���� �����ؾ� �� �޼���
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld~");
		
		response.setContentType("text/html; charset=UTF-8");
		//����(�������� ����) �� �������� ���ڷε� html�̰� ���ڸ� UTF-8����� ����
		PrintWriter writer = response.getWriter();
		//PrintWriter�� ����� ó���ϴ� ��ü
		//���귿������ html������ PrintWriter��ü�� println()�޼���� �������
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
