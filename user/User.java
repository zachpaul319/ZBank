package user;
import java.util.ArrayList;

import accounts.Account;
import accounts.CD;
import cards.Card;
import loans.Loan;

public interface User {
	public String getUsername();
	public String getPassword();
	public String getSecurityQuestion();
	public String getSecurityAnswer();
	public ArrayList<Account> getOpenAccounts();
	public ArrayList<Card> getActiveCards();
	public ArrayList<Loan> getActiveLoans();
	public ArrayList<CD> getActiveCDs();
	public void changeUsername(String newName);
	public void changePassword();
	public void changePassword(String newPassword);
	public boolean hasOpenAccounts();
	public boolean hasActiveCards();
	public boolean hasActiveLoans();
	public boolean hasActiveCDs();
}
