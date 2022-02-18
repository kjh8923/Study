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
@Controller 	//@Controller�� Ŭ������ ControllerŬ������ �����ϴ� ������̼�
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping�� ��û��θ� ó���ϴ� ������̼�
	//value�� ��û��� method�� ��û ���(RequestMethod.GET/POST)
	//org.springframework.web.bind.annotation.RequestMethod
	//�Ʒ� �޼���� @RequestMapping�� ��û��ν� ó�����ִ� �޼���
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; 	
		// home�� /WEB-INF/views/home.jsp�� ��Ÿ�� 
		// /WEB-INF/views/�� .jsp�� servlet-content.xml���� �����ؼ� ��������
	}
	
	@RequestMapping("/board/view") 	//��û��θ� ���ô� value, method���� ��θ� ǥ��, �̶� �޼���� Ŭ���̾�Ʈ ��û ����� �ڵ����� ����
	public String view() {
		return "board/view"; 	// board/view.jsp�� �̵�
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		// org.springframework.ui.Model�� �����͸� ó���ϴ� Ŭ����
		// DispatcherServlet���� Model��ü�� �����Ͽ� ����
		model.addAttribute("id", 30); // �Ķ��Ÿ�� ù��°��  String�̰� 2��°�� Object
		//model�� ������ �Ӽ��� �̵��� jsp�������� ������
		return "board/content"; 	
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		//ModelAndViewŬ������ Model�� View�ΰ��� ó���ϴ� Ŭ����
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		//Model�� addAttribute�̰� ModelAndView�� addObject�޼��带 ���
		mv.setViewName("board/reply"); //view�� ����
		
		return mv;
	}
	
}
