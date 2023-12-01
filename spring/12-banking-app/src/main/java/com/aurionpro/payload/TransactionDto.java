package com.aurionpro.payload;

import java.util.Date;
import java.util.List;

import com.aurionpro.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
    private int transactionId;
    private String transType;
    private Date transDate;
    private double amount;
    private double receiverAccount;
    
    
    
	public TransactionDto(int transactionId, String transType, Date transDate, double amount, double receiverAccount) {
		super();
		this.transactionId = transactionId;
		this.transType = transType;
		this.transDate = transDate;
		this.amount = amount;
		this.receiverAccount = receiverAccount;
	}
	private List<Transaction> content;
	private int pageNumber;
	private int numberOfElements;
	private long totalElements;
	private int totalPages;
	private boolean hasNext;
	private boolean hasPrevious;
	private boolean isFirst;
	private boolean isLast;



	public TransactionDto(List<Transaction> content, int pageNumber, int numberOfElements, long totalElements,
			int totalPages, boolean hasNext, boolean hasPrevious, boolean isFirst, boolean isLast) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.numberOfElements = numberOfElements;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.hasNext = hasNext;
		this.hasPrevious = hasPrevious;
		this.isFirst = isFirst;
		this.isLast = isLast;
	}
	
	

}
