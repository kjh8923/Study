package com.kjh.ch02ex01;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("main �޼���");
		Calculation calculation = new Calculation();
		
		calculation.setFirstNum(10);
		calculation.setSecondNum(2);
		
		calculation.addition();
	}

}
