package com.kjh.ch03ex02;
//IOC�����̳ʿ��� bean���� ���� Ŭ������ �����ڿ� setter�޼��尡 �־�� ��
public class MyCalculator {

	//�������
	Calculator calculator; //�ܺ� Ŭ���� ��ü
	private int firstNum; //�⺻�� ��� ����
	private int secondNum; //�⺻�� ��� ����
	
	//�⺻�� ������
	public MyCalculator() {
		super();
	}
	
	//setter�޼��� ����, getter�� �׳� ����
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	//�߰� �ʿ� �޼���
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
}