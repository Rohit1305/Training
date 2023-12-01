package com.aurionpro.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.model.Role;
import com.aurionpro.model.User;
import com.aurionpro.payload.CustomerRegistorDto;
import com.aurionpro.payload.DocumentDto;
import com.aurionpro.payload.LoginDto;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.DocumentRepository;
import com.aurionpro.repository.RoleRepository;
import com.aurionpro.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer registerCustomer(CustomerRegistorDto customerDto) {
		Role customerRole = roleRepository.findById(2).get();
		User user = new User(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getPassword(),
				customerDto.getEmail());
		user.setRole(customerRole);
		user = userRepository.save(user);
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPassword(customerDto.getPassword());
		customer.setEmail(customerDto.getEmail());
		customer.setActive(true);
		customer.setUser(user);
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer customerLogin(LoginDto loginDto) {
		return customerRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
	}

//	@Override
//	public Document uploadFile(MultipartFile file) throws IOException {
//
//		DocumentDto documentDto = new DocumentDto();
//		documentDto.setTitle(file.getOriginalFilename());
//		documentDto.setFileUploaded(file.getBytes());
//
//		Document document = new Document();
//		document.setTitle(file.getOriginalFilename());
//		document.setFileUploaded(file.getBytes());
//		document.setStatus(documentDto.getStatus());
//		documentRepository.save(document);
//		return document;
//	}
//
//	@Override
//	public ResponseEntity<ByteArrayResource> downloadFile(int id) {
//
//		Optional<Document> optionalDocument = documentRepository.findById(id);
//		if (optionalDocument.isPresent()) {
//			Document document = optionalDocument.get();
//			ByteArrayResource resource = new ByteArrayResource(document.getFileUploaded());
//			return ResponseEntity.ok()
//					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + document.getTitle())
//					.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(document.getFileUploaded().length)
//					.body(resource);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
//	@Override
//	public String accountCreationRequest(int bankId, int customerId, List<MultipartFile> files) {
//
//		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
//		if (optionalCustomer.isPresent()) {
//			Customer customer = optionalCustomer.get();
//			for (MultipartFile file : files) {
//				if (!file.isEmpty()) {
//					try {
//						byte[] fileData = file.getBytes();
//						Document document = new Document();
//						document.setTitle(file.getOriginalFilename());
//						document.setUploadDate(new Date());
//						document.setFileUploaded(fileData);
//						document.setCustomer(customer);
//						document.setStatus("PENDING");
//						documentRepository.save(document);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			return "Account request sent";
//		} else {
//			return "Customer not found.";
//		}
//	}

}
