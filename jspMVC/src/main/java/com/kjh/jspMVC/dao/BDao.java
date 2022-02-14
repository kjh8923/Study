package com.kjh.jspMVC.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	//DBCP사용
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
	
	//게시판 처리에 필요한 게시판 내용 만들기(insert), 게시판 내용보기(select), 수정하기 등등 ... 필요한 메서드 작성
}
