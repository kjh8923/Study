package com.kjh.ch09ex02;

import org.aspectj.lang.ProceedingJoinPoint;

//aspect클래스
public class LogAop {
	//각 포인트컷에서 실행시기에 따른 여러개의 어드바이스 정의
	
	//<aop:around>
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
	
	//<aop:before> - 포인트컷의 핵심기능 메서드 실행전 advice실행
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	//<aop:after-returning> - 포인트컷의 핵심기능 메서드 실행이 정상으로 실행 후 advice실행
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//<aop:after-throwing> - 포인트컷의 핵심기능 메서드 실행이 예외 발생시 advice실행
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}

	//<aop:after> - 포인트컷의 핵심기능 메서드 실행이 정상이든 예외 발생이든 advice실행
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
