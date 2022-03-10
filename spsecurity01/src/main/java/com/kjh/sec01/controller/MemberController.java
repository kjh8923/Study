package com.kjh.sec01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	//회원가입부
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
}
