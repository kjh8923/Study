package com.kjh.mybatis01.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjh.mybatis01.dto.TicketDto;

//dao에서 transaction처리 클래스
//Service와 Transactional 어노테이션을 사용 
@Service
@Transactional
//transaction 처리 메서드를 다시 작성하여 여기서 호출 
public class UserTransaction {

	public boolean transActionEx(ContentDao dao, TicketDto dto) {
		//card처리 메서드
		dao.writeCard(dto);
		//ticket처리 메서드
		dao.writeTicket(dto);
		
		return true;
	}
}
