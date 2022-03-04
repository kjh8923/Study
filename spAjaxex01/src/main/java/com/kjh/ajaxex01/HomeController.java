package com.kjh.ajaxex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
		return "springAjax1";
	}
	
	@RequestMapping(value = "/formact", produces = "aplication/text; charset=UTF8")
	//produces는 ajax시 한글깨짐 방지
	@ResponseBody //return을 jsp페이지가 아닌 문자열이나 객체형으로 할 시에 사용
	public String formact(Jamong jamong) {
		return jamong.getName() + " and " + jamong.getAge();
		//Jamong클래스의 멤버변수값을 가져와 문자열로 클라이언트로 반환
	}
	
	@RequestMapping(value = "/requestObject", produces = "aplication/text; charset=UTF8")
	@ResponseBody
	public String simpleWithObject(Jamong jamong) {
		return jamong.getName() + " and " + jamong.getAge();
	}
}
