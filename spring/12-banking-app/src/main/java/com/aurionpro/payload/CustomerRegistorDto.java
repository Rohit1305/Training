package com.aurionpro.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CustomerRegistorDto {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private boolean active;
	public CustomerRegistorDto(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.active = true;
	}

	

	
	
	
	
	
	

}
