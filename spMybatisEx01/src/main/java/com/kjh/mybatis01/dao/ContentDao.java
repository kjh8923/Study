package com.kjh.mybatis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kjh.mybatis01.dto.ContentDto;
import com.kjh.mybatis01.dto.TicketDto;

public class ContentDao implements IDao {

	@Autowired //�ʵ� ��Ŀ� ���� Autowired
	private SqlSession sqlSession; //field Autowired ������ SqlSessionTemplate��ü��(���� �������̽�)
	
	public ContentDao() {
		//�⺻������
	}
	
	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0, mWriter, mContent);
		sqlSession.insert("writeDao", dto);
		//insert�� sql�� insert�� ó���ϴ� SqlSession�� �޼���
		//ù��° �Ķ��Ÿ�� �޼����̸�(xml�� id��)�� ���ڿ��� ǥ��
		//�ι�° �Ķ��Ÿ�� xml�� sql�� �����ϴ� �Ķ��Ÿ�� object��
	}
	
	@Override
	public ArrayList<ContentDto> listDao(){
		ArrayList<ContentDto> result = (ArrayList)sqlSession.selectList("listDao");
		//selectList(�޼����̸�)�� Object�� ��ȯ�ϹǷ� (ArrayList)�� ����ȯ
		//selectList()�޼���� ��񿡼� �ټ����� resultset�� ��ȯ�ϴµ� ���
		return result;
	}

	@Override
	public void deleteDao(String bId) {
		sqlSession.delete("deleteDao", Integer.parseInt(bId));
		//form�̳� <a>���� ��û����� �Ķ��Ÿ���� ���ڿ��̰� DB���� ��Ű�� mid�� �������̹Ƿ� ������ ��ȯ
	}

	@Override
	public ArrayList<ContentDto> viewDao(String mId) {
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		//selectOne()�޼���� select�� ����� �ϳ��� ���ڵ� �Ͻ� ���(������ ��Ű�Ͻ�)
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
