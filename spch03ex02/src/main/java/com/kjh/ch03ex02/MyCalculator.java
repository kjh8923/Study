package com.kjh.ch03ex02;
//IOC콘테이너에서 bean으로 사용될 클래스로 생성자와 setter메서드가 있어야 함
public class MyCalculator {

	//멤버변수
	Calculator calculator; //외부 클래스 객체
	private int firstNum; //기본형 멤버 변수
	private int secondNum; //기본형 멤버 변수
	
	//기본형 생성자
	public MyCalculator() {
		super();
	}
	
	//setter메서드 생성, getter는 그냥 만듦
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
	
	//추가 필요 메서드
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
}