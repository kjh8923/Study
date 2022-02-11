package com.kjh.ch20ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP를 이용하는 DAO
public class DbcpDAO {
	private DataSource dataSource;
	//DBCP에서 Connection객체를 만드는데 사용할 객체를 선언
	
	public DbcpDAO() {
		try {
			Context context = new InitialContext();
			//Context는 이름으로 객체를 찾아주는 인터페이스
			//InitialContext는 Context인터페이스를 구현한 클래스
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			//context의 lookup(찾는 클래스명)메서드는 찾는 클래스의 객체를 반환
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect(){
		//MemberDTO 객체를 원소로 갖는 ArrayList객체 dtos를 만듦
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//크기가 조정되는 배열 형식으로 원소는 MemberDTO객체를 가진다
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//DBCP에서 Connection객체를 얻는 것만 dataSource를 이용하고
			//나머지 절차는 똑같음
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member01");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				MemberDTO dto = new MemberDTO(id, pw, name, phone);
				//각각의 레코드(ResultSet의 원소)를 DTO객체로 만듦
				dtos.add(dto);
				//ArrayList객체 dtos에 dto객체 추가
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return dtos;
	}
}
