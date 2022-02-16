package com.kjh.ch06ex02;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml��� bean�� �������ִ� Ŭ����

@Configuration
//@Configuration ������̼��� ApplicationConfigŬ������ ���������� ���� Ŭ�������� ��Ÿ��
public class ApplicationConfig {
	@Bean
	public Student student1() {
		//����Ÿ���� Student�� bean�� Ŭ������
		//�޼���� student1�� ���� id
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		Student student = new Student("ȫ�浿", 20, hobbys); //�����ڷ� �Ӽ��� ����
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		//����Ÿ���� Student�� bean�� Ŭ������
		//�޼���� student2�� ���� id
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("����");
		Student student = new Student("ȫ����", 25, hobbys); //�����ڷ� �Ӽ��� ����
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
}
