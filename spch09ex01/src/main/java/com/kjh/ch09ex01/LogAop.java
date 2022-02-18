package com.kjh.ch09ex01;

import org.aspectj.lang.ProceedingJoinPoint;

//횡단기능(공통기능)으로 사용할 클래스
//스프링에서는 메서드만 횡단기능 aspect로 사용
public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		//ProceedingJoinPoint 클래스는 aop:around시 proceed()메서드를 사용하게 하는 클래스
		String signatureStr = joinpoint.getSignature().toShortString();
		//진행되는 현재 조인트포인트 위치의 메서드 이름을 반환
		//getSignature()는 Signature객체를 반환하고 toShortString()은 문자열로 반환
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed(); 
			//핵심기능 메서드를 실행하고 공통기능 메서드인 이 메서드는 여기서 보류하고 있다가 핵심기능 메서드가 종료되면 공통기능 메서드인 이 메서드가 다시 진행 
			return obj; //finally 실행 후 리턴(예외가 없을시만 리턴) 
		}
		finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "경과시간 : " + (et - st));
		}
	}
}
