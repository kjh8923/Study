package com.kjh.ch25ex01.Command;

public class InsertCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("command에서 요청 처리");

	}

}
