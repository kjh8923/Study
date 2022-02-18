package com.kjh.ch12ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller 	//@Controller는 클래스를 Controller클래스로 설정하는 어노테이션
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping은 요청경로를 처리하는 어노테이션
	//value는 요청경로 method는 요청 방식(RequestMethod.GET/POST)
	//org.springframework.web.bind.annotation.RequestMethod
	//아래 메서드는 @RequestMapping의 요청경로시 처리해주는 메서드
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; 	
		// home은 /WEB-INF/views/home.jsp를 나타냄 
		// /WEB-INF/views/과 .jsp를 servlet-content.xml에서 설정해서 조립해줌
	}
	
	@RequestMapping("/board/view") 	//요청경로만 사용시는 value, method없이 경로만 표시, 이때 메서드는 클라이언트 요청 방식을 자동으로 적용
	public String view() {
		return "board/view"; 	// board/view.jsp로 이동
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		// org.springframework.ui.Model는 데이터를 처리하는 클래스
		// DispatcherServlet에서 Model객체는 생성하여 전달
		model.addAttribute("id", 30); // 파라메타의 첫번째는  String이고 2번째는 Object
		//model에 설정된 속성은 이동한 jsp페이지에 보내짐
		return "board/content"; 	
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		//ModelAndView클래스는 Model과 View두개를 처리하는 클래스
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		//Model은 addAttribute이고 ModelAndView은 addObject메서드를 사용
		mv.setViewName("board/reply"); //view값 설정
		
		return mv;
	}
	
}
