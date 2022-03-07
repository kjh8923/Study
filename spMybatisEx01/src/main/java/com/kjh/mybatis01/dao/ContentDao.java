package com.kjh.mybatis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kjh.mybatis01.dto.ContentDto;
import com.kjh.mybatis01.dto.TicketDto;

public class ContentDao implements IDao {

	@Autowired //필드 방식에 의한 Autowired
	private SqlSession sqlSession; //field Autowired 실제는 SqlSessionTemplate객체임(상위 인터페이스)
	
	public ContentDao() {
		//기본생성자
	}
	
	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0, mWriter, mContent);
		sqlSession.insert("writeDao", dto);
		//insert는 sql문 insert를 처리하는 SqlSession의 메서드
		//첫번째 파라메타는 메서드이름(xml의 id값)을 문자열로 표시
		//두번째 파라메타는 xml의 sql로 전달하는 파라메타로 object형
	}
	
	@Override
	public ArrayList<ContentDto> listDao(){
		ArrayList<ContentDto> result = (ArrayList)sqlSession.selectList("listDao");
		//selectList(메서드이름)은 Object를 반환하므로 (ArrayList)로 형변환
		//selectList()메서드는 디비에서 다수개의 resultset을 반환하는데 사용
		return result;
	}

	@Override
	public void deleteDao(String bId) {
		sqlSession.delete("deleteDao", Integer.parseInt(bId));
		//form이나 <a>에서 요청경로의 파라메타값은 문자열이고 DB에서 주키값 mid는 정수값이므로 정수로 변환
	}

	@Override
	public ArrayList<ContentDto> viewDao(String mId) {
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		//selectOne()메서드는 select의 결과가 하나의 레코드 일시 사용(조건이 주키일시)
		ArrayList<ContentDto> dtos = new ArrayList<ContentDto>();
		dtos.add(result);
		return dtos;
	}
	
	@Override
	public void writeCard(TicketDto dto) {
		sqlSession.insert("writeCard", dto);
	}
	
	@Override
	public void writeTicket(TicketDto dto) {
		sqlSession.insert("writeTicket", dto);
	}

}
