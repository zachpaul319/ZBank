package loans;
import accounts.Account;

public class AutoLoan extends Loan {
	private static final long serialVersionUID = 10;
	private static final int SHORT_TERM_LENGTH = 7;
	private static final double SHORT_TERM_IR = 5.00;
	private static final int LONG_TERM_LENGTH = 10;
	private static final double LONG_TERM_IR= 8.00;
	
	public AutoLoan(Account accountTo, double loanAmount, double interestRate, int term) {
		super(accountTo, loanAmount, interestRate, term);
	}
	
	public static int getShortTermLength() {
		return SHORT_TERM_LENGTH;
	}
	
	public static double getShortTermIR() {
		return SHORT_TERM_IR;
	}
	
	public static int getLongTermLength() {
		return LONG_TERM_LENGTH;
	}
	
	public static double getLongTermIR() {
		return LONG_TERM_IR;
	}
	
	@Override
	public String collateralMessage() {
		return ("We are taking your car as collateral!");
	}
	
	
}
