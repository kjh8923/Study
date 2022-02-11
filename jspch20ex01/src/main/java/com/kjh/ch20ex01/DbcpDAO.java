package com.kjh.ch20ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP�� �̿��ϴ� DAO
public class DbcpDAO {
	private DataSource dataSource;
	//DBCP���� Connection��ü�� ����µ� ����� ��ü�� ����
	
	public DbcpDAO() {
		try {
			Context context = new InitialContext();
			//Context�� �̸����� ��ü�� ã���ִ� �������̽�
			//InitialContext�� Context�������̽��� ������ Ŭ����
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			//context�� lookup(ã�� Ŭ������)�޼���� ã�� Ŭ������ ��ü�� ��ȯ
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect(){
		//MemberDTO ��ü�� ���ҷ� ���� ArrayList��ü dtos�� ����
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//ũ�Ⱑ �����Ǵ� �迭 �������� ���Ҵ� MemberDTO��ü�� ������
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//DBCP���� Connection��ü�� ��� �͸� dataSource�� �̿��ϰ�
			//������ ������ �Ȱ���
			con = dataSource.getConnection();
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
