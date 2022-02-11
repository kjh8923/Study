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
	
	public MemberDAO(){ //�����ڷ� ��ü ������ ����Ŭ����̹� �ε�
		try {
			Class.forName(driver); //dirver�� �ε�Ǿ� DriverManagerŬ���� Ȱ��ȭ
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect(){
		//MemberDTO ��ü�� ���ҷ� ���� ArrayList��ü dtos�� ����
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//ũ�Ⱑ �����Ǵ� �迭 �������� ���Ҵ� MemberDTO��ü�� ������
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
				//������ ���ڵ�(ResultSet�� ����)�� DTO��ü�� ����
				dtos.add(dto);
				//ArrayList��ü dtos�� dto��ü �߰�
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
