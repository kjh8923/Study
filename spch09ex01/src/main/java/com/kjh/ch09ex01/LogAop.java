package com.kjh.ch09ex01;

import org.aspectj.lang.ProceedingJoinPoint;

//Ⱦ�ܱ��(������)���� ����� Ŭ����
//������������ �޼��常 Ⱦ�ܱ�� aspect�� ���
public class LogAop {
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
}
