package loans;
import accounts.Account;

public class Mortgage extends Loan {
	//MORTGAGE_TERM = 30;
	//MORTGAGE_IR = 4.25;
	private static final long serialVersionUID = 11;

	public Mortgage(Account accountTo, double loanAmount, double interestRate, int term) {
		super(accountTo, loanAmount, interestRate, term);
	}
	
	@Override
	public String collateralMessage() {
		return ("We are taking your house as collateral!");
	}
}
