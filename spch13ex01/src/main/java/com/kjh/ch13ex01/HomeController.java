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
		// HttpServletRequest�� getParameter�� getParameterValues�޼���� Ŭ���̾�Ʈ���� ���� �Ķ��Ÿ�� ��ȯ
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "confirmId";
	}
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		//@RequestParam("id")�� request ��ü�� id �Ķ��Ÿ ���� �Ķ��Ÿ �������� ���� ����
		//request.getParameter()�� ����� �ʿ� ����
		
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
		// addAttribute(String attr, Object obj)�̹Ƿ� ������ ��ü�� �־ ��
		return "join";
	}
	
	@RequestMapping("/join")
	public String join(Member member) {
		//DTO��ü�� �ٷ� ����ϸ� �ڵ����� �̵��������� DTO��ü�� �߰�����
		//�Ķ��Ÿ���� �ҹ��� Ŭ���������� ��
		return "joinM";
	}
	
	@RequestMapping("/student/{studentId}")
	//{studentId}�� ������ �ּ�â���� "/��"���� ��û�� ���� �����ϴ� ����������  @PathVariable�� ���� �����Ǵ� �Ķ��Ÿ ������ ��� 
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "studentView";
	}
}
