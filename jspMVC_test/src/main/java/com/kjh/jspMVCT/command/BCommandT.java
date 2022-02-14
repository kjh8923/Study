package com.kjh.jspMVCT.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommandT {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
