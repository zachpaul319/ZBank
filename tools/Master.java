package tools;
import java.io.Serializable;
import java.util.HashMap;

import accounts.CheckingAccount;

public class Master implements Serializable {
	private static final long serialVersionUID = 13;
	private static CheckingAccount masterAccount = new CheckingAccount(Long.MAX_VALUE, "Master Account");
	private static HashMap<String, String> userPass = new HashMap<>();
	private static HashMap<String, String> userAnswer = new HashMap<>();
	
	public static void deposit(double amount) {
		masterAccount.deposit(amount);
	}
	
	public static void withdraw(double amount) {
		masterAccount.withdraw(amount);
	}
	
	public static CheckingAccount getMasterAccount() {
		return masterAccount;
	}
	
	public static HashMap<String, String> getUserPass() {
		return userPass;
	}
	
	public static HashMap<String, String> getUserAnswer() {
		return userAnswer;
	}
}
