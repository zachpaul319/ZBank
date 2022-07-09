package accounts;
public class SavingsAccount extends Account {
	private static final long serialVersionUID = 4;
	private static final double APY = 0.09;
	private static final double DECIMAL_APY = APY/100;
	private static final double MONTHLY_INTEREST_RATE = APY/12;
	private static final double MONTHLY_DECIMAL_INTEREST_RATE = DECIMAL_APY/12;
	
	public SavingsAccount(double initialAmount, String accountName) {
		super(initialAmount, accountName);
	}
	
	public static double getAPY() {
		return APY;
	}
	
	public static double getDecimalAPY() {
		return DECIMAL_APY;
	}
	
	public static double getMonthlyInterestRate() {
		return MONTHLY_INTEREST_RATE;
	}
	
	public static double getMonthlyDecimalInterestRate() {
		return MONTHLY_DECIMAL_INTEREST_RATE;
	}
	
	public double monthlyInterestEarned() {
		return (balance * MONTHLY_DECIMAL_INTEREST_RATE);
	}
	
	public double annualInterestEarned() {
		return (balance * DECIMAL_APY);
	}
	
	public void depositMonthlyInterest() {
		balance += this.monthlyInterestEarned();
	}
	
	public void depositAnnualInterest() {
		balance += this.annualInterestEarned();
	}
}
