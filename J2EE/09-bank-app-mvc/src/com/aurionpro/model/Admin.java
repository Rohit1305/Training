package com.aurionpro.model;

public class Admin {

	private int id;
	private String admin_name;
	private String email;
	private String pass;
	private String mob;

	public Admin(int id, String admin_name, String email, String pass, String mob) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.email = email;
		this.pass = pass;
		this.mob = mob;
	}

	public Admin(String email, String pass) {
		this.email = email;
		this.pass = pass;	
	}

	public int getId() {
		return id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public String getMob() {
		return mob;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", admin_name=" + admin_name + ", email=" + email + ", pass=" + pass + ", mob=" + mob
				+ "]";
	}
	
}