package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private boolean active;
	
	
	
	

	@ManyToMany
	@JoinTable(name = "customer_fdaccount",
	joinColumns =@JoinColumn(name="customer_Id"),
	inverseJoinColumns = @JoinColumn(name="fd_account_id"))
	private List<FdAccount> fdAccount =new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "customer_bank", 
	joinColumns = @JoinColumn(name = "customer_id"), 
	inverseJoinColumns = @JoinColumn(name = "bank_id"))
	private List<Bank> bank = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bank_id")
//	private Bank bank;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Account> accountList = new ArrayList<>();

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Document> documentList = new ArrayList<>();



}
