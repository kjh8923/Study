package com.kjh.ch09ex02;

public class Worker {
	private String name;
	private int age;
	private String job;
	
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	//추가 메서드
		public void getWorkerInfo() {
			System.out.println("이름 : " + getName());
			System.out.println("나이 : " + getAge());
			System.out.println("직업 : " + getJob());
		}
}
