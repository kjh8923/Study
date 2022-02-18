package com.kjh.ch09ex02;

import org.aspectj.lang.ProceedingJoinPoint;

//aspectŬ����
public class LogAop {
	//�� ����Ʈ�ƿ��� ����ñ⿡ ���� �������� �����̽� ����
	
	//<aop:around>
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
	
	//<aop:before> - ����Ʈ���� �ٽɱ�� �޼��� ������ advice����
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	//<aop:after-returning> - ����Ʈ���� �ٽɱ�� �޼��� ������ �������� ���� �� advice����
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//<aop:after-throwing> - ����Ʈ���� �ٽɱ�� �޼��� ������ ���� �߻��� advice����
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}

	//<aop:after> - ����Ʈ���� �ٽɱ�� �޼��� ������ �����̵� ���� �߻��̵� advice����
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
