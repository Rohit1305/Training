package com.aurionpro.service;

import java.util.List;

import com.aurionpro.payload.AccountRequestDto;
import com.aurionpro.payload.DocumentDto;

public interface AccountRequestService {

	List<AccountRequestDto> getPendingAccountRequests();

	void processAccountRequest(int requestId, String status);

	AccountRequestDto createAccountRequest(AccountRequestDto requestDto);

	void addDocumentByCustomer(int customerId, DocumentDto documentDto);

	List<DocumentDto> getDocumentsForCustomer(int customerId);

}
