package com.kjh.mybatis01.dto;

//form과 매핑하는 데이터 클래스
public class TicketDto {
	private String consumerId;
	private String amount;
	
	public TicketDto() {
		super();
	}

	public TicketDto(String consumerId, String amount) {
		super();
		this.consumerId = consumerId;
		this.amount = amount;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
