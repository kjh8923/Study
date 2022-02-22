package com.kjh.ch22ex02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjh.ch22ex02.dao.TicketDao;
import com.kjh.ch22ex02.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private TicketDao dao;
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}
	
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
		
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
		System.out.println("buy_ticket_card 요청");
		
		// 파라메타로 dto사용시 자동 dto객체 생성
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		dao.buyTicket(ticketDto);
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}
	
}
