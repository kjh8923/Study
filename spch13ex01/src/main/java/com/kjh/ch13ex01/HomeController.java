package com.kjh.ch13ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
		// HttpServletRequest의 getParameter나 getParameterValues메서드로 클라이언트에서 오는 파라메타값 반환
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "confirmId";
	}
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		//@RequestParam("id")는 request 객체의 id 파라메타 값을 파라메타 변수값에 직접 대입
		//request.getParameter()를 사용할 필요 없음
		
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "checkId";
	}
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		// addAttribute(String attr, Object obj)이므로 값으로 객체를 넣어도 됨
		return "join";
	}
	
	@RequestMapping("/join")
	public String join(Member member) {
		//DTO객체를 바로 사용하면 자동으로 이동페이지에 DTO객체를 추가해줌
		//파라메타명은 소문자 클래스명으로 함
		return "joinM";
	}
	
	@RequestMapping("/student/{studentId}")
	//{studentId}는 브라우저 주소창에서 "/값"으로 요청시 값을 지정하는 변수명으로  @PathVariable에 의해 지정되는 파라메타 값으로 사용 
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "studentView";
	}
}
