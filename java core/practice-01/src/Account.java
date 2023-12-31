
public class Account {
	private int id;
	private String name;
	private double balance;
	private AccountType account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public Account(int id, String name, double balance, AccountType account) {
		
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.account = account;
	}
	
	
	
	

}
