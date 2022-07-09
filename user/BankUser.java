package user;
import java.io.Serializable;
import java.util.ArrayList;

import accounts.Account;
import accounts.CD;
import cards.Card;
import loans.Loan;
import tools.Master;
import tools.Password;

public class BankUser implements User, Serializable {
	private static final long serialVersionUID = 1;
	private String username, password;
	private String securityQuestion, securityAnswer;
	private ArrayList<Account> openAccounts = new ArrayList<>();
	private ArrayList<Card> activeCards = new ArrayList<>();
	private ArrayList<Loan> activeLoans = new ArrayList<>();
	private ArrayList<CD> activeCDs = new ArrayList<>();
	
	public BankUser(String username, String password, String securityQuestion, String securityAnswer) {
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		
		Master.getUserPass().put(username, password);
		Master.getUserAnswer().put(username, securityAnswer);
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	
	public ArrayList<Account> getOpenAccounts(){
		return openAccounts;
	}
	
	public ArrayList<Card> getActiveCards() {
		return activeCards;
	}
	
	public ArrayList<Loan> getActiveLoans() {
		return activeLoans;
	}
	
	public ArrayList<CD> getActiveCDs() {
		return activeCDs;
	}
	
	public void changeUsername(String newName) {
		username = newName;
	}
	
	public void changePassword() {
		password = Password.generatePassword();
	}
	
	public void changePassword(String newPassword) {
		password = newPassword;
	}
	
	public boolean hasOpenAccounts() {
		return openAccounts.size() > 0;
	}
	
	public boolean hasActiveCards() {
		return activeCards.size() > 0;
	}
	
	public boolean hasActiveLoans() {
		return activeLoans.size() > 0;
	}
	
	public boolean hasActiveCDs() {
		return activeCDs.size() > 0;
	}
}
