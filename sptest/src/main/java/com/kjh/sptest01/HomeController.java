package com.kjh.sptest01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		*/
		
		model.addAttribute("name", "kjh" );
		//�Ӽ��̸� name���� �� "kjh"�� ����
		//return������ home.jsp���� model���� ���
		//EL�� �ٷ� �Ӽ��̸����� ���
		return "home";
		//WEB-INF/views/home.jsp�� ǥ���� �־�� �ϳ� 
		//servlet-context.xml���� WEB-INF/views/�� .jsp�� �����Ǿ� home(jsp���� �̸�)�� ���
	}
	
	@RequestMapping("/test")
	//��û��δ� form�� action�Ӽ���, <a href= >��
	public String test(Model model) {
		model.addAttribute("name", "������");
		model.addAttribute("age", 32);
		return "test";	
	}
	
}