package com.kjh.map.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kjh.map.dto.ContentDto;

public class ContentDao implements IDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public  ContentDao() {
		
	}
	
	@Override
	public void writeDao(String title, String content, String latitude, String longitude, String placeName) {
		ContentDto dto = new ContentDto(0, title, content, latitude, longitude, placeName);
		sqlSession.insert("writeDao", dto);

	}

}
