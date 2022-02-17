package com.kjh.ch06ex03;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //������ IOC�������Ϸ� ����� ������̼�
public class ApplicationConfig {
	
	@Bean //������ �����̳��� bean�� ����� ������̼�
	//�޼���� bean�� Ŭ������ ����Ÿ������(Student) �ϰ� �޼��� �̸��� bean�̸�(student1)
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		Student student = new Student("ȫ�浿", 20, hobbys); //�����ڷ� �Ӽ��� ����
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
}
