package com.aurionpro.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fdplan")
public class FdPlan {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "number_of_days")
	private int numberOfDays;
	@Column(name = "interest")
	private int interest;
	@Column(name = "active")
	private String active;

	@OneToMany(mappedBy = "fdPlan")
	@JsonIgnore
	private List<FdAccount> fdAccount;
	


}
