
public class AccountTest {

	public static void main(String[] args) {
		
		Account account=new Account(101, "Jay", 1000, AccountType.CURRENT);
		System.out.println(account);
		
		printDepositMessage(account,account.deposit(1010));
		printDepositMessage(account,account.deposit(3010));
		printWithdrawMessage(account,account.withdraw(31000));
	}

	private static void printWithdrawMessage(Account account, boolean withdraw) {
		if(withdraw) {
			System.out.println("Withdrawal successful...\n"+ account);
		}
		else {
			System.out.println("Could not withdraw..transaction failed!!");
		}
	}

	private static void printDepositMessage(Account account, boolean deposit) {
		if(deposit) {
			System.out.println("Deposited successfully...\n"+ account);
		}
		else {
			System.out.println("Could not deposit..transaction failed!!");
		}
	    }

	

}
