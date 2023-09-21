
public class Account {
	private long accountNumber;
	private String name;
	private double balance;
	private AccountType account;
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", account="
				+ account + "]";
	}

	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getAccount() {
		return account;
	}
	public void setAccount(AccountType account) {
		this.account = account;
	}
	public Account(long accountNumber, String name, double balance, AccountType account) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.account = account;
	}
	
	

	

}
