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
	//서브렛 객체 생성(한번만 생성)
    public LifeCycleEx() {
        super();
        System.out.println("construct");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //Servlet 객체 생성 후 초기화시 한번만 실행
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	//Servlet 종료 시 한번 호출
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//맨처음 요청시에 호출되는 메서드로 여기서 doGet이나 doPost를 호출 해줌
	//보통은 상위의 HttpServlet의 메서드로 사용하므로 재정의 필요 없음
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
	//@PostConsstruct는 어노테이션으로 서브렛 객체생성 후 실행할 메서드를 지정
	//어노테이션에 지정된 메서드 이름은 임의로 지정
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	//서블렛이 종료되기전에 실행되는 메서드 정의
	private void destroyPreDestory() {
		System.out.println("destoryPreDestory");
	}
}
