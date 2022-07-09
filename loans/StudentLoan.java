package loans;
import accounts.Account;

public class StudentLoan extends Loan {
	//TERM = 15
	//IR = 7.00
	private static final long serialVersionUID = 12;

	public StudentLoan(Account accountTo, double loanAmount, double interestRate, int term) {
		super(accountTo, loanAmount, interestRate, term);
	}
	
	@Override
	public String collateralMessage() {
		return("We are taking your college degree as collateral!");
	}
}
