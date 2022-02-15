package com.kjh.jspMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kjh.jspMVC.dto.BDto;

public class BDao {
	//DBCP���
	DataSource dataSource;
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
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
	
	//�ʿ��� �޼��� ����� �߰�
	public void write(String bName, String bTitle, String bContent) {
		//command���� ȣ��� �����ϴ� �Ķ��Ÿ�� �̿��Ͽ� db�� insert
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO MVC_BOARD(BID, BNAME, BTITLE, BCONTENT, BHIT, BGROUP, BSTEP, BINDENT)"
							+ "VALUES(MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			int rn = preparedStatement.executeUpdate(); //insert���̹Ƿ� executeUpdate()�� ���
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> list(){
		//db���� select������ ���ڵ带 ������
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC,BSTEP ASC";
			//ORDER BY DESC�� ��������, ASC�� ������������ ����
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery(); //SELECT�� �̹Ƿ� executeQuery()�� ���
			//resultSet�� �������� ���ڵ带 ���ҷ� ����
			
			//���ҵ��� �ϳ��� ����
			while(resultSet.next()) {
				//resultSet�� ��� �ִ� ������ �÷����� get��������("�÷���")���� �����Ѵ�
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate"); //oracle�� date���� java���� Timestamp�� ���(import �ؾ� ��)
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				//���� ������ Ŭ������ BDtoŬ������ ��ü�� ��ȯ
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				//ArrayList dtos�� dto��ü �߰�
			    dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
				if(resultSet != null)
					resultSet.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return dtos;
	}
}
