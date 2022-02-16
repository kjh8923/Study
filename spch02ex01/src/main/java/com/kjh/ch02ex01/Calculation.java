package com.kjh.ch02ex01;

public class Calculation {
	private int firstNum;
	private int secondNum;
	
	public Calculation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculation(int firstNum, int secondNum) {
		super();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
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
	
	public void addition() {
		System.out.println("addition()");
		int result = firstNum + secondNum;
		System.out.println(firstNum + "+" + secondNum + "=" + (firstNum+secondNum));
	}
}
