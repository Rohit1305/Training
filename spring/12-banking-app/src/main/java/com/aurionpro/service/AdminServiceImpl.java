package com.aurionpro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Account;
import com.aurionpro.model.Admin;
import com.aurionpro.model.Bank;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.model.Role;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;
import com.aurionpro.payload.AccountDto;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.LoginDto;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.AdminRepository;
import com.aurionpro.repository.BankRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.DocumentRepository;
import com.aurionpro.repository.RoleRepository;
import com.aurionpro.repository.TransactionRepository;
import com.aurionpro.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	

	public AdminServiceImpl(CustomerRepository customerRepository, DocumentRepository documentRepository,
			TransactionRepository transactionRepository, AccountRepository accountRepository,
			BankRepository bankRepository) {
		super();
		this.customerRepository = customerRepository;
		this.documentRepository = documentRepository;
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
		this.bankRepository = bankRepository;
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {

		customerRepository.deleteById(id);
	}

	@Override
	public Customer activateCustomer(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setActive(true);
			return customerRepository.save(customer);
		}
		return null;
	}

	@Override
	public Customer deactivateCustomer(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setActive(false);
			return customerRepository.save(customer);
		}
		return null;
	}
	
	@Override
	public Admin registerAdmin(AdminRegistorDto adminDto) {
		Role adminRole = roleRepository.findById(1).get();
		User user = new User(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getPassword(),
				adminDto.getEmail());
		user.setRole(adminRole);
		user = userRepository.save(user);
		Admin admin = new Admin();
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
		admin.setPassword(adminDto.getPassword());
		admin.setEmail(adminDto.getEmail());
		admin.setActive(true);
		admin.setUser(user);
		adminRepository.save(admin);
		return admin;
	}

//	@Override
//	public Customer processAccountRequest(Customer customer) {
//		if (customer.get) {
//	        
//	        return customerRepository.save(customer);
//	    } 
//		else if (customer.getStatus().equalsIgnoreCase("rejected")) {
//	        customer.setStatus("rejected");
//	        List<Document> customerDocuments = documentRepository.findByCustomer(customer);
//	        for (Document document : customerDocuments) {
//	            document.setStatus("rejected");
//	            documentRepository.save(document);
//	        }
//	        return customerRepository.save(customer);
//	    } else {
//	        return null;
//	    }
//	}



//	@Override
//	public Document acceptDocument(int id) {
//		Optional<Document> optionalDocument = documentRepository.findById(id);
//		if (optionalDocument.isPresent()) {
//			Document document = optionalDocument.get();
//			document.setStatus("Accepted");
//			return documentRepository.save(document);
//		}
//		return null;
//	}
//
//	@Override
//	public Document rejectDocument(int id) {
//		Optional<Document> optionalDocument = documentRepository.findById(id);
//		if (optionalDocument.isPresent()) {
//			Document document = optionalDocument.get();
//			document.setStatus("Rejected");
//			return documentRepository.save(document);
//		}
//		return null;
//	}
	
	@Override
	public List<Transaction> getTransactionsByDateAndAccount(Date startDate, Date endDate, int accountNo) {
		return transactionRepository.findByTransDateBetweenAndAccount_AccountNo(startDate, endDate, accountNo);
	}

	@Override
	public Admin adminLogin(LoginDto loginDto) {
		return adminRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findAdminById(int id) {
		return adminRepository.findById(id).get();
	}

//	@Override
//	public String accountCreationResponse(AccountDto acDto, int documentId, String status) {
//
//		Optional<Document> optionalDocument = documentRepository.findById(documentId);
//		if (optionalDocument.isPresent()) {
//			Document document = optionalDocument.get();
//			if ("ACCEPTED".equalsIgnoreCase(status)) {
//				document.setStatus("ACCEPTED");
//				documentRepository.save(document);
//
//				Bank bank = bankRepository.findById(acDto.getBank().getBankId()).get();
//				System.out.println(bank);
//
//				Customer customer = document.getCustomer();
//				customer.setBank(bank);
//				Account account = new Account(acDto.getAccountType(), acDto.getBank());
//				account.setCustomer(customer);
//				accountRepository.save(account);
//
//				return "Account created ";
//			} else if ("REJECTED".equalsIgnoreCase(status)) {
//				document.setStatus("REJECTED");
//				documentRepository.save(document);
//
//				return "Account creation request rejected";
//			} else {
//				return "provide 'ACCEPTED' or 'REJECTED'.";
//			}
//		} else {
//			return "Document not found.";
//		}
//	}

}
