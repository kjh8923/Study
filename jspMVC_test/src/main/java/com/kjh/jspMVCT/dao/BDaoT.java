package com.kjh.jspMVCT.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDaoT {
	
	DataSource dataSource;
	
	public BDaoT() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
