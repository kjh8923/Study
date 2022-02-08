package com.kjh.ch06ex01;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet("/LCE")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//���귿 ��ü ����(�ѹ��� ����)
    public LifeCycleEx() {
        super();
        System.out.println("construct");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //Servlet ��ü ���� �� �ʱ�ȭ�� �ѹ��� ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	//Servlet ���� �� �ѹ� ȣ��
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//��ó�� ��û�ÿ� ȣ��Ǵ� �޼���� ���⼭ doGet�̳� doPost�� ȣ�� ����
	//������ ������ HttpServlet�� �޼���� ����ϹǷ� ������ �ʿ� ����
	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	
	//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

	@PostConstruct
	//@PostConsstruct�� ������̼����� ���귿 ��ü���� �� ������ �޼��带 ����
	//������̼ǿ� ������ �޼��� �̸��� ���Ƿ� ����
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	//������ ����Ǳ����� ����Ǵ� �޼��� ����
	private void destroyPreDestory() {
		System.out.println("destoryPreDestory");
	}
}
