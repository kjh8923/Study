package com.kjh.jspMVC.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
//Ȯ���� .do�� ����ϴ� frontcontroller ���귿
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		request.setCharacterEncoding("UTF-8"); //post�� �ѱ�ó��, get�� server���� ���� ��
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");
		String viewPage = null; //�̵��� jsp������
		
		String uri = request.getRequestURI(); //port��ȣ ������ ���(���ؽ�Ʈ �н� ���� ���������� ���)
		String conPath = request.getContextPath(); //���ؽ�Ʈ �н�
		String com = uri.substring(conPath.length()); //���ؽ�Ʈ�н��� ������ ��� ���� / xxx.do
	}

}
