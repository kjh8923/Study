package com.kjh.ch10ex01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//어노테이션으로 aspect클래스 설정시 사용
@Aspect
public class LogAop {
	//이 aspect에서 사용할 Pointcut을 정의
	@Pointcut("within(com.kjh.ch10ex01.*)")
	private void pointcutMethod() {
		//@Pointcut용 메서드를 정의해 주어야만 하는데 아무런 일도 하지않게 정의
	}
	
	@Around("pointcutMethod()") 	//@Pointcut의 메서드를 사용
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

	@Before("within(com.kjh.ch10ex01.*)") 	//파라메타로 pointcut의 expression인 within(com.kjh.ch10ex01.*)사용
	//<aop:before> - 포인트컷의 핵심기능 메서드 실행전 advice실행
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
//@Pointcut("execution(public void get*(..))")	// public void인 모든 get메소드
//@Pointcut("execution(* com.javalec.ex.*.*())")// com.javalec.ex 패키지에 파라미터가 없는 모든 메소드
//@Pointcut("execution(* com.javalec.ex..*.*())")
//com.javalec.ex 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 모든 메소드
//@Pointcut("execution(* com.javalec.ex.Worker.*())")// com.javalec.ex.Worker 안의 모든 메소드
//within은 클래스를 지정하여 그 클래스안의 메서드들
//@Pointcut("within(com.javalec.ex.*)")	//com.javalec.ex 패키지 안에 있는 모든 메소드
//@Pointcut("within(com.javalec.ex..*)")  //com.javalec.ex 패키지 및 하위 패키지 안에 있는 모든 메소드
//@Pointcut("within(com.javalec.ex.Worker)") //com.javalec.ex.Worker 모든 메소드

//bean을 선택하여 그 빈이 가진 메서드들
//@Pointcut("bean(student)")	//student 빈에만 적용
//@Pointcut("bean(*ker)")		//~ker로 끝나는 빈에만 적용
