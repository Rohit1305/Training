package com.aurionpro.service;

import java.util.List;

import com.aurionpro.model.Document;

public interface DocumentService {

	List<Document> findByCustomer(int customerId);

}
