package com.kjh.mybatis01.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjh.mybatis01.dto.TicketDto;

//dao���� transactionó�� Ŭ����
//Service�� Transactional ������̼��� ��� 
@Service
@Transactional
//transaction ó�� �޼��带 �ٽ� �ۼ��Ͽ� ���⼭ ȣ�� 
public class UserTransaction {

	public boolean transActionEx(ContentDao dao, TicketDto dto) {
		//cardó�� �޼���
		dao.writeCard(dto);
		//ticketó�� �޼���
		dao.writeTicket(dto);
		
		return true;
	}
}
