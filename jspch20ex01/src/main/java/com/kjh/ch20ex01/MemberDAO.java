package com.kjh.ch20ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO(){ //생성자로 객체 생성시 오라클드라이버 로딩
		try {
			Class.forName(driver); //dirver가 로드되어 DriverManager클래스 활성화
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect(){
		//MemberDTO 객체를 원소로 갖는 ArrayList객체 dtos를 만듦
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//크기가 조정되는 배열 형식으로 원소는 MemberDTO객체를 가진다
		try {
			con = DriverManager.getConnection(url,uid,upw);
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
