package extra;
import java.io.*;

import cards.DebitCard;

public class BankTester {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		CheckingAccount checkingAccount = new CheckingAccount(0, "First Account");
		SavingsAccount savingsAccount = new SavingsAccount(1.26, "Second Account");
		
		checkingAccount.deposit(1.26);
		savingsAccount.deposit(3);
		
		System.out.println(checkingAccount.getAccountName());
		System.out.printf("$%.2f\n", checkingAccount.getBalance());
		System.out.println(checkingAccount.getAccountNumber());
		
		System.out.println();
		
		System.out.println(savingsAccount.getAccountName());
		System.out.printf("$%.2f\n", savingsAccount.getBalance());
		System.out.println(savingsAccount.getAccountNumber());
		
		
		DebitCard card = new DebitCard();
		
		System.out.println(card.getCardNumber());
		System.out.println(card.getCVV());
		System.out.println(card.getExpirationDate());
		System.out.println(card.getPIN());
		System.out.println(card.isExpired());
		
		
		SignUp signUp = new SignUp();
		Thread signUpThread = new Thread(signUp);
		
		signUpThread.start();
		
		
		BankUser zach = new BankUser("ZachPaul", "Password", "Question", "Answer");
		
		CheckingAccount zachChecking = new CheckingAccount(5000, "Zach's Checking");
		zach.getOpenAccounts().add(zachChecking);
		
		zachChecking.activateDebitCard();
		zach.getActiveCards().add(zachChecking.getDebitCard());
		
		FileOutputStream fileOut = new FileOutputStream("User.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		out.writeObject(zach);
		
		System.out.println("Object info saved!");
		
		out.close(); fileOut.close();
	
		
		BankUser zach;
		
		FileInputStream fileIn = new FileInputStream("User.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		zach = (BankUser) in.readObject();
		
		in.close(); fileIn.close();
		
		Account zachChecking = zach.getOpenAccounts().get(0);
		Card zachDebit = zach.getActiveCards().get(0);
		
		double balance = zachChecking.getBalance();
		long number = zachChecking.getAccountNumber();
		String name = zachChecking.getAccountName();
		
		long cardNumber = zachDebit.getCardNumber();
		String expireDate = zachDebit.getExpirationDate();
		String cvv = zachDebit.getCVV();
		String pin = zachDebit.getPIN();
		
		System.out.println(zach.getUsername());
		System.out.println(zach.getPassword());
		
		System.out.println(balance);
		System.out.println(number);
		System.out.println(name);
		
		System.out.println(cardNumber);
		System.out.println(expireDate);
		System.out.println(cvv);
		System.out.println(pin);
		
		DebitCard card = new DebitCard();
		
		System.out.println(card.getCardNumber());
		System.out.println(card.getExpirationDate());
		System.out.println(card.getCVV());
		System.out.println(card.getPIN());
		*/
	}
}
