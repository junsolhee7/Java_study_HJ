package com.iu.home.bankBook;

import java.util.Calendar;

public class BankBookDTO {
	
	private Long ca;
	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	
	
	public Long getCa() {
		return ca;
	}
	public void setCa(Calendar ca) {
		this.ca = ca.getTimeInMillis();
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	

}
