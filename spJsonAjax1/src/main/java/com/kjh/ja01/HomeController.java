package com.kjh.ja01;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
		return "jsonAjax";
	}
	
	@RequestMapping(value = "/stringify", produces = "application/json; charset=UTF8")
	@ResponseBody
	public HashMap<String, Object> stringify(@RequestBody Jamong jamong){
		//@RequestBody는 json으로 보낸 파라메터를 받아서 처리하는 어노테이션
		System.out.println("json");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", jamong.getName());
		map.put("age", jamong.getAge());
		
		return map; //map객체를 json형태로 반환
	}
	
}
