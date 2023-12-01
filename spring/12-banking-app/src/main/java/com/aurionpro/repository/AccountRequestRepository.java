package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.AccountRequest;
import com.aurionpro.payload.AccountRequestDto;

public interface AccountRequestRepository extends JpaRepository<AccountRequest, Integer>{

	List<AccountRequest> findByStatus(String string);

}
