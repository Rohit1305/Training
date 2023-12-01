package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fdaccount")
public class FdAccount {
	@Id
	@Column(name = "fd_account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fdAccountId;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "maturity_date")
	private Date maturityDate;
	@Column(name = "fd_amount")
	private int fdAmount;
	@Column(name = "maturity_amount")
	private int maturityAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fd_plan_id")
	private FdPlan fdPlan;
	
	@ManyToMany(mappedBy = "fdAccount")
	 private List<Customer> customer = new ArrayList<>();
	

}
