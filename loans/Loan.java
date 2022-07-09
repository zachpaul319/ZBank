package loans;
import java.io.Serializable;
import java.util.GregorianCalendar;

import accounts.Account;
import tools.DateManagement;
import tools.Master;

public abstract class Loan implements Serializable {
	private static final long serialVersionUID = 9;
	protected final double LOAN_AMOUNT, INTEREST_RATE, DECIMAL_INTEREST_RATE, TOTAL_INTEREST, 
	TOTAL_AMOUNT_DUE, MINIMUM_MONTHLY_PAYMENT;
	protected final int TERM, STARTING_DAY;
	protected GregorianCalendar payDay;
	protected double balanceRemainingActual, balanceRemainingShouldBe;
	protected int monthsPassed;
	
	public Loan(Account accountTo, double loanAmount, double interestRate, int term) {
		LOAN_AMOUNT = loanAmount;
		
		accountTo.deposit(loanAmount);
		Master.withdraw(loanAmount);
		
		INTEREST_RATE = interestRate;
		DECIMAL_INTEREST_RATE = INTEREST_RATE/100;
		TOTAL_INTEREST = LOAN_AMOUNT * DECIMAL_INTEREST_RATE;
		
		TOTAL_AMOUNT_DUE = LOAN_AMOUNT + TOTAL_INTEREST;
		balanceRemainingActual = TOTAL_AMOUNT_DUE;
		balanceRemainingShouldBe = TOTAL_AMOUNT_DUE;
		
		TERM = term;
		STARTING_DAY = DateManagement.getDay();
		
		MINIMUM_MONTHLY_PAYMENT = (TOTAL_AMOUNT_DUE / TERM) / 12;
		
		monthsPassed = 0;
		
		setPayDay();
	}
	
	private void setPayDay() {
		DateManagement.setExpirationDate("month", 1);
		payDay = DateManagement.getExpirationDate();
	}
	
	private void setPayDay(int whatYear, int whatMonth, int whatDay) {
		DateManagement.setManualDate(whatYear, whatMonth, whatDay);
		payDay = DateManagement.getManualDate();
	}
	
	public double getLoanAmount() {
		return LOAN_AMOUNT;
	}
	
	public double getInterestRate() {
		return INTEREST_RATE;
	}
	
	public double getDecimalInterestRate() {
		return DECIMAL_INTEREST_RATE;
	}
	
	public double getTotalInterest() {
		return TOTAL_INTEREST;
	}
	
	public double getTotalAmountDue() {
		return TOTAL_AMOUNT_DUE;
	}
	
	public double getMinimumMonthlyPayment() {
		return MINIMUM_MONTHLY_PAYMENT;
	}
	
	public int getTerm() {
		return TERM;
	}
	
	public int getStartingDay() {
		return STARTING_DAY;
	}
	
	public double getBalanceRemaining() {
		return balanceRemainingActual;
	}
	
	private void findBalanceRemainingShouldBe() {
		balanceRemainingShouldBe = TOTAL_AMOUNT_DUE - (MINIMUM_MONTHLY_PAYMENT * monthsPassed);
	}
	
	public double getBalanceRemainingShouldBe() {
		return balanceRemainingShouldBe;
	}
	
	private boolean missedPayment() {
		findBalanceRemainingShouldBe();
		return (balanceRemainingActual > balanceRemainingShouldBe);
	}
	
	public void makeMonthlyPayment(Account fromAccount) {
		fromAccount.withdraw(MINIMUM_MONTHLY_PAYMENT);
		Master.deposit(MINIMUM_MONTHLY_PAYMENT);
		balanceRemainingActual -= MINIMUM_MONTHLY_PAYMENT;
	}
	
	public void makeManualPayment(Account fromAccount, double amount) {
		fromAccount.withdraw(amount);
		Master.deposit(amount);
		balanceRemainingActual -= amount;
	}
	
	private boolean isPayDay() {
		return (DateManagement.getCurrentDate() == payDay);
	}
	
	private boolean isAfterPayDay() {
		return (DateManagement.getCurrentDate().after(payDay));
	}
	
	private boolean isOrPastPayDay() {
		return (isPayDay() || isAfterPayDay());
	}
	
	public void completePayDayChecklist() {
		if (isOrPastPayDay()) {
			monthsPassed += 1;
			if (missedPayment()) {
				//do something
			} else {
				if (isPayDay()) {
					setPayDay();
				} else {
					if (DateManagement.getMonth() == 11) {
						setPayDay(DateManagement.getYear() + 1, 0, STARTING_DAY);
					} else {
						setPayDay(DateManagement.getYear(), DateManagement.getMonth() + 1, STARTING_DAY);
					}
				}
			}
		}
	}
	
	public abstract String collateralMessage();
}
