package com.aurionpro.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Account;
import com.aurionpro.model.AccountRequest;
import com.aurionpro.model.AccountType;
import com.aurionpro.model.Bank;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.payload.AccountRequestDto;
import com.aurionpro.payload.DocumentDto;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.AccountRequestRepository;
import com.aurionpro.repository.AccountTypeRepository;
import com.aurionpro.repository.BankRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.DocumentRepository;

@Service
public class AccountRequestServiceImpl implements AccountRequestService {

	@Autowired
	private AccountRequestRepository accountRequestRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	private DocumentRepository documentRepository;

	public AccountRequestServiceImpl(AccountRequestRepository accountRequestRepository,
			AccountRepository accountRepository, CustomerRepository customerRepository, BankRepository bankRepository,
			AccountTypeRepository accountTypeRepository, DocumentRepository documentRepository) {
		super();
		this.accountRequestRepository = accountRequestRepository;
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
		this.bankRepository = bankRepository;
		this.accountTypeRepository = accountTypeRepository;
		this.documentRepository = documentRepository;
	}

	private AccountRequestDto mapToDto(AccountRequest request) {
		AccountRequestDto dto = new AccountRequestDto();
		dto.setId(request.getId());
		dto.setCustomerId(request.getCustomer().getCustomerId());
		dto.setBankId(request.getBank().getBankId());
		dto.setTypeId(request.getAccountType() != null ? request.getAccountType().getTypeId() : null);
		dto.setStatus(request.getStatus());
		return dto;
	}

	private DocumentDto mapToDocumentDto(Document document) {
		DocumentDto dto = new DocumentDto();
		dto.setId(document.getId());
		dto.setTitle(document.getTitle());
		dto.setDocumentUrl(document.getDocumentUrl());
		dto.setUploadDate(document.getUploadDate());
		return dto;
	}

	private Account createAccount(AccountType accountType, Bank bank, Customer customer) {
		Account account = new Account();
		account.setActive(true);
		account.setBalance(0);
		account.setAccountType(accountType);
		account.setBank(bank);
		account.setCustomer(customer);

		return account;
	}

	@Override
	public List<AccountRequestDto> getPendingAccountRequests() {
		List<AccountRequest> pendingRequests = accountRequestRepository.findByStatus("PENDING");
		return pendingRequests.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public void processAccountRequest(int requestId, String status) {

		AccountRequest request = accountRequestRepository.findById(requestId).orElse(null);
		if (request != null) {
			if (status.equals("ACCEPTED")) {
				AccountType accountType = request.getAccountType();
				Bank bank = request.getBank();
				Customer customer = request.getCustomer();
				Account account = createAccount(accountType, bank, customer);
				accountRepository.save(account);
				request.setStatus(status);
				accountRequestRepository.save(request);
			} else if (status.equals("REJECTED")) {
				request.setStatus(status);
			}
			accountRequestRepository.save(request);
		}

	}

	@Override
	public AccountRequestDto createAccountRequest(AccountRequestDto requestDto) {

		Customer customer = customerRepository.findById(requestDto.getCustomerId()).orElse(null);
		Bank bank = bankRepository.findById(requestDto.getBankId()).orElse(null);
		AccountType accountType = accountTypeRepository.findById(requestDto.getTypeId()).orElse(null);
		System.out.println(customer);
		System.out.println(bank);
		System.out.println(accountType);
		if (customer != null && bank != null) {
			System.out.println("HHHHHHHHHH");
			AccountRequest request = new AccountRequest();
			request.setCustomer(customer);
			request.setBank(bank);
			request.setAccountType(accountType);
			request.setStatus("PENDING");

			accountRequestRepository.save(request);
			return mapToDto(request);
		}
		return null;
	}

	@Override
	public void addDocumentByCustomer(int customerId, DocumentDto documentDto) {

		Customer customer = customerRepository.findById(customerId).orElse(null);

		if (customer != null) {
			Document document = new Document();
			document.setCustomer(customer);
			document.setTitle(documentDto.getTitle());
			document.setDocumentUrl(documentDto.getDocumentUrl());
			document.setUploadDate(new Date());

			documentRepository.save(document);
		}
	}

	@Override
	public List<DocumentDto> getDocumentsForCustomer(int customerId) {

		Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer != null) {
            List<Document> documents = customer.getDocumentList();
            return documents.stream()
                    .map(this::mapToDocumentDto)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
	}

}
