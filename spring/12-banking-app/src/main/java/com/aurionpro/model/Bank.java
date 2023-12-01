package com.aurionpro.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@Column(name = "bank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "branch")
	private String branch;
	@Column(name = "ifsc_code")
	private String ifscCode;

	
	
	@ManyToMany(mappedBy = "bank")
	@JsonIgnore
	private List<Customer> customerList;
	
	@OneToMany(mappedBy="bank")
	@JsonIgnore
	private List<Account> accountList;
}
