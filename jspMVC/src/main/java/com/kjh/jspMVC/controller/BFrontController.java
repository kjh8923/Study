package com.kjh.jspMVC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.jspMVC.command.BCommand;
import com.kjh.jspMVC.command.BListCommand;
import com.kjh.jspMVC.command.BWriteCommand;


/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
//Ȯ���� .do�� ����ϴ� frontcontroller ���귿
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BCommand command;
       
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
		System.out.println(com);
		
		if(com.equals("/")) {
			System.out.println("context path�Դϴ�.");
			viewPage = "WriteForm.jsp"; //MVC�� view ������
		}
		else if(com.equals("/write.do")) {
			System.out.println("write.do ��û�Դϴ�.");
			//WriteForm.jsp���� �Է��� �Խ��� �ۼ� ������ ó��
			command = new BWriteCommand();
			//������ ���� ó���ϴ� command�� �ش� command��ü�� ����
			command.execute(request, response);
			//command�� ���� ó���ϴ� �޼��� execute(request, response) ȣ��
			//�Խ��� �ۼ��� ������ �Խ��� ���â�� ó��
			viewPage = "list.do";
		}
		else if(com.equals("/list.do")) {
			System.out.println("list.do ��û�Դϴ�.");
			//list.do��û�� �Խ��� ����Ʈâ�� ����(�Խ����� ���ڵ���� �����ͼ� view�� list.jsp�������� ����)
			command = new BListCommand();
			command.execute(request, response);
			//request��ü�� db�� resultSet�� ��ȯ�� ArrayList��ü list�� �߰��Ǿ� ����
			//list.jsp�������� �������̵� ��û�� request�۾��̹Ƿ� list.jsp���� request��ü�� ����Ͽ� db�� ���ڵ� resultSet���� �ݿ� 
			viewPage = "list.jsp";
		}
		else if(com.equals("/writeFormView.do")) {
			System.out.println("writeFormView.do ��û�Դϴ�.");
			viewPage = "WriteForm.jsp";
		}
		
		//view �������� ������ �̵�
		if(viewPage == null) {
			System.out.println("viewPage�� �����ϴ�.");
		}
		else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); //MVC�� view�������� �̵�
		}
	}

}
