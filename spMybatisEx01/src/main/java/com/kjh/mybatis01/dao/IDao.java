package com.kjh.mybatis01.dao;

import java.util.ArrayList;

import com.kjh.mybatis01.dto.ContentDto;
import com.kjh.mybatis01.dto.TicketDto;

//Mybatis에서 mapper인터페이스
//실제 처리할 sql에 대한 각각의 추상메서드를 정의
public interface IDao {
	//추상메서드
	public void writeDao(String mWriter, String mContent);
	public ArrayList<ContentDto> listDao();
	public void deleteDao(String bId);
	public ArrayList<ContentDto> viewDao(String mId);
	//transaction처리
	public void writeCard(TicketDto dto);
	public void writeTicket(TicketDto dto);
}
