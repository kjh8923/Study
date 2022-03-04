package com.kjh.ajax02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		//return "home";
		return "getPost";
	}
	
	@RequestMapping(value="/ajaxGet", produces="application/text; charset=UTF8")
	//produces�Ӽ��� ajax�ѱ� ó��
	@ResponseBody //��ȯ�� jsp������ �ƴ� �Ϲ� ���ڿ��� ��ȯ�ÿ� ���
	public String ajaxGet(HttpServletRequest request, HttpServletResponse response) {
		return "get method ����"; //�������� ������ ���ڿ�, $.get()�� �ݹ� �Լ� data�� ����
	}
	
	@RequestMapping(value="/ajaxPost", produces="application/text; charset=UTF8")
	@ResponseBody
	public String ajaxPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		return "post method ����"; //�������� ������ ���ڿ�, $.post()�� �ݹ� �Լ� data�� ����
	}
	
}
