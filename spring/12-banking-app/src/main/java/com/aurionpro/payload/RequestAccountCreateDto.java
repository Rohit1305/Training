package com.aurionpro.payload;

import java.util.List;

import com.aurionpro.model.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAccountCreateDto {
	private int customerId;
    private List<Document> documents;
	public RequestAccountCreateDto(int customerId) {
		super();
		this.customerId = customerId;
	}

}
