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
	//DBCP사용
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
	
	//게시판 처리에 필요한 게시판 내용 만들기(insert), 게시판 내용보기(select), 수정하기 등등 ... 필요한 메서드 작성
	
	//필요한 메서드 만들어 추가
	public void write(String bName, String bTitle, String bContent) {
		//command에서 호출시 전달하는 파라메타를 이용하여 db에 insert
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO MVC_BOARD(BID, BNAME, BTITLE, BCONTENT, BHIT, BGROUP, BSTEP, BINDENT)"
							+ "VALUES(MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			int rn = preparedStatement.executeUpdate(); //insert문이므로 executeUpdate()문 사용
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
		//db에서 select문으로 레코드를 가져옴
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC,BSTEP ASC";
			//ORDER BY DESC는 내림차순, ASC는 오름차순으로 정렬
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery(); //SELECT문 이므로 executeQuery()문 사용
			//resultSet은 복수개의 레코드를 원소로 가짐
			
			//원소들을 하나씩 추출
			while(resultSet.next()) {
				//resultSet에 들어 있는 원소의 컬럼값은 get데이터형("컬럼명")으로 추출한다
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate"); //oracle의 date형은 java에서 Timestamp를 사용(import 해야 함)
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				//매핑 데이터 클래스인 BDto클래스의 객체로 변환
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				//ArrayList dtos에 dto객체 추가
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
