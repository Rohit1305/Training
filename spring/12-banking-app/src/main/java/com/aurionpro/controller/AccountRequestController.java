package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.payload.AccountRequestDto;
import com.aurionpro.payload.DocumentDto;
import com.aurionpro.repository.AccountRequestRepository;
import com.aurionpro.service.AccountRequestService;

@RestController
@RequestMapping("/request")
public class AccountRequestController {
    @Autowired
    private AccountRequestService accountRequestService;
    
    public AccountRequestController(AccountRequestService accountRequestService) {
		super();
		this.accountRequestService = accountRequestService;
	}

	@GetMapping("/pending")
    public List<AccountRequestDto> getPendingAccountRequests() {
        return accountRequestService.getPendingAccountRequests();
    }

    @PostMapping("/process/{requestId}")
    public void processAccountRequest(@PathVariable int requestId, @RequestParam String status) {
        accountRequestService.processAccountRequest(requestId, status);
    }

    @PostMapping("/create")
    public AccountRequestDto createAccountRequest(@RequestBody AccountRequestDto requestDto) {
    	System.out.println("contrller");
        return accountRequestService.createAccountRequest(requestDto);
    }

    @PostMapping("/documents/customers/{customerId}")
    public void addDocumentByCustomer(@PathVariable int customerId, @RequestBody DocumentDto documentDto) {
        accountRequestService.addDocumentByCustomer(customerId, documentDto);
    }

    @GetMapping("/documents/customers/{customerId}")
    public List<DocumentDto> getDocumentsForCustomer(@PathVariable int customerId) {
        return accountRequestService.getDocumentsForCustomer(customerId);
    }

}
