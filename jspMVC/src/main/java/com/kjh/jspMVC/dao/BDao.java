package com.kjh.jspMVC.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	//DBCP���
	DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�Խ��� ó���� �ʿ��� �Խ��� ���� �����(insert), �Խ��� ���뺸��(select), �����ϱ� ��� ... �ʿ��� �޼��� �ۼ�
}