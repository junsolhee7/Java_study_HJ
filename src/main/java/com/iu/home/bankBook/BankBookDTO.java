package com.iu.home.bankBook;

import java.util.Calendar;
import java.util.List;

import com.iu.home.bankAccount.BankAccountDTO;

public class BankBookDTO {
	
	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private String bookContents;
	private List<BankAccountDTO> bankAccountDTOs;//1:n관계
	
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
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	
	


}
