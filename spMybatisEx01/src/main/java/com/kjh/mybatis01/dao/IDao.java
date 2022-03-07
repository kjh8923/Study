package com.kjh.mybatis01.dao;

import java.util.ArrayList;

import com.kjh.mybatis01.dto.ContentDto;
import com.kjh.mybatis01.dto.TicketDto;

//Mybatis���� mapper�������̽�
//���� ó���� sql�� ���� ������ �߻�޼��带 ����
public interface IDao {
	//�߻�޼���
	public void writeDao(String mWriter, String mContent);
	public ArrayList<ContentDto> listDao();
	public void deleteDao(String bId);
	public ArrayList<ContentDto> viewDao(String mId);
	//transactionó��
	public void writeCard(TicketDto dto);
	public void writeTicket(TicketDto dto);
}
