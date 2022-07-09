package accounts;
import java.io.Serializable;
import java.util.Random;

public abstract class Account implements Serializable {
	private static final long serialVersionUID = 2;
	protected final long ACCOUNT_NUMBER;
	protected String accountName;
	protected double balance;
	protected boolean open;
	
	public Account(double initialAmount, String accountName) {
		open = true;
		balance = initialAmount;
		this.accountName = accountName;
		
		Random rand = new Random();
		ACCOUNT_NUMBER = Math.abs(rand.nextLong());
	}
	
	public double getBalance() {
		return balance;
	}
	
	public long getAccountNumber() {
		return ACCOUNT_NUMBER;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void changeAccountName(String newName) {
		accountName = newName;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void transferMoney(Account whichAccount, double amount) {
		whichAccount.deposit(amount);
		withdraw(amount);
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void close() {
		open = false;
	}
	
}
