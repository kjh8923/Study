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
		//속성이름 name으로 값 "kjh"를 설정
		//return페이지 home.jsp에서 model값을 사용
		//EL로 바로 속성이름으로 사용
		return "home";
		//WEB-INF/views/home.jsp로 표시해 주어야 하나 
		//servlet-context.xml에서 WEB-INF/views/와 .jsp가 지정되어 home(jsp파일 이름)만 사용
	}
	
	@RequestMapping("/test")
	//요청경로는 form의 action속성값, <a href= >값
	public String test(Model model) {
		model.addAttribute("name", "고재현");
		model.addAttribute("age", 32);
		return "test";	
	}
	
}
