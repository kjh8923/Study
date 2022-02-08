package com.kjh.ch08ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInitParam
 */
@WebServlet(
		urlPatterns = { "/SIP" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "abcdf"), 
				@WebInitParam(name = "pw", value = "1234"), 
				@WebInitParam(name = "path", value = "C:\\myweb")
		})
public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("doGet");
				//web.xml에서 지정한 파라메타는 GET방식으로 전달됨
				String id = this.getInitParameter("id");
				//getInitParameter()메서드는 web.xml에 설정된 <init-param>의 파라메터를 반환
				//getInitParameter(파라메타명)는 인터페이스 ServeletConfig의 메서드로 서브렛 클래스의 상위 클래스에서
				//ServeletConfig를 구현하였으므로 우리가 만든 서브렛 클래스는 이 메서드를 멤버메서드로 가지고 있어
				//바로 사용 가능(this는 본 서브렛 객체임을 강조하기 위해 사용)
				String pw = getInitParameter("pw");
				String path = getInitParameter("path");
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				
				writer.println("<html><head></head><body>");
				writer.println("아이디 : " + id + "<br/>");
				writer.println("비밀번호 : " + pw + "<br/>");
				writer.println("path : " + path);
				writer.println("</body></html>");
				
				writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
