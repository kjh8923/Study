package com.kjh.ch10ex01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//������̼����� aspectŬ���� ������ ���
@Aspect
public class LogAop {
	//�� aspect���� ����� Pointcut�� ����
	@Pointcut("within(com.kjh.ch10ex01.*)")
	private void pointcutMethod() {
		//@Pointcut�� �޼��带 ������ �־�߸� �ϴµ� �ƹ��� �ϵ� �����ʰ� ����
	}
	
	@Around("pointcutMethod()") 	//@Pointcut�� �޼��带 ���
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		//ProceedingJoinPoint Ŭ������ aop:around�� proceed()�޼��带 ����ϰ� �ϴ� Ŭ����
		String signatureStr = joinpoint.getSignature().toShortString();
		//����Ǵ� ���� ����Ʈ����Ʈ ��ġ�� �޼��� �̸��� ��ȯ
		//getSignature()�� Signature��ü�� ��ȯ�ϰ� toShortString()�� ���ڿ��� ��ȯ
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed(); 
			//�ٽɱ�� �޼��带 �����ϰ� ������ �޼����� �� �޼���� ���⼭ �����ϰ� �ִٰ� �ٽɱ�� �޼��尡 ����Ǹ� ������ �޼����� �� �޼��尡 �ٽ� ���� 
			return obj; //finally ���� �� ����(���ܰ� �����ø� ����) 
		}
		finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "����ð� : " + (et - st));
		}
	}

	@Before("within(com.kjh.ch10ex01.*)") 	//�Ķ��Ÿ�� pointcut�� expression�� within(com.kjh.ch10ex01.*)���
	//<aop:before> - ����Ʈ���� �ٽɱ�� �޼��� ������ advice����
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
//@Pointcut("execution(public void get*(..))")	// public void�� ��� get�޼ҵ�
//@Pointcut("execution(* com.javalec.ex.*.*())")// com.javalec.ex ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//@Pointcut("execution(* com.javalec.ex..*.*())")
//com.javalec.ex ��Ű�� & com.javalec.ex ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//@Pointcut("execution(* com.javalec.ex.Worker.*())")// com.javalec.ex.Worker ���� ��� �޼ҵ�
//within�� Ŭ������ �����Ͽ� �� Ŭ�������� �޼����
//@Pointcut("within(com.javalec.ex.*)")	//com.javalec.ex ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//@Pointcut("within(com.javalec.ex..*)")  //com.javalec.ex ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//@Pointcut("within(com.javalec.ex.Worker)") //com.javalec.ex.Worker ��� �޼ҵ�

//bean�� �����Ͽ� �� ���� ���� �޼����
//@Pointcut("bean(student)")	//student �󿡸� ����
//@Pointcut("bean(*ker)")		//~ker�� ������ �󿡸� ����
