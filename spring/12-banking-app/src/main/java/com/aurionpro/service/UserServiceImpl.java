package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Admin;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Role;
import com.aurionpro.model.User;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.CustomerRegistorDto;
import com.aurionpro.repository.AdminRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.RoleRepository;
import com.aurionpro.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	
	
	public UserServiceImpl(CustomerRepository customerRepository, RoleRepository roleRepository,
			UserRepository userRepository, AdminRepository adminRepository) {
		super();
		this.customerRepository = customerRepository;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

//	@Override
//	public Customer registerCustomer(CustomerRegistorDto customerDto) {
//		Role customerRole = roleRepository.findById(2).get();
//		User user = new User(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getPassword(),
//				customerDto.getEmail());
//		user.setRole(customerRole);
//		user = userRepository.save(user);
//		Customer customer = new Customer();
//		customer.setFirstName(customerDto.getFirstName());
//		customer.setLastName(customerDto.getLastName());
//		customer.setPassword(customerDto.getPassword());
//		customer.setEmail(customerDto.getEmail());
//		customer.setActive(true);
//		customer.setUser(user);
//		customerRepository.save(customer);
//		return customer;
//	}

//	@Override
//	public Admin registerAdmin(AdminRegistorDto adminDto) {
//		Role adminRole = roleRepository.findById(1).get();
//		User user = new User(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getPassword(),
//				adminDto.getEmail());
//		user.setRole(adminRole);
//		user = userRepository.save(user);
//		Admin admin = new Admin();
//		admin.setFirstName(adminDto.getFirstName());
//		admin.setLastName(adminDto.getLastName());
//		admin.setPassword(adminDto.getPassword());
//		admin.setEmail(adminDto.getEmail());
//		admin.setActive(true);
//		admin.setUser(user);
//		adminRepository.save(admin);
//		return admin;
//	}



}
