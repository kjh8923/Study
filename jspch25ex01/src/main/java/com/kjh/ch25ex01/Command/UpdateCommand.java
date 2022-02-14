package com.kjh.ch25ex01.Command;
//command 패턴으로 사용하기 위해 커맨드용 인터페이스를 구현한 클래스
public class UpdateCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("update 커맨트 처리");
		
		
	}

}
