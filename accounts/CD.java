package accounts;
import java.io.Serializable;

public class CD implements Serializable {
	private static final long serialVersionUID = 5;
	private static final double APY = 0.016;
	private final int TERM;
	private final double DEPOSIT_AMOUNT;
	
	public CD(double depositAmount, int term) {
		this.DEPOSIT_AMOUNT = depositAmount;
		this.TERM = term;
	}
	
	public static double getAPY() {
		return APY;
	}
	
	public int getTerm() {
		return TERM;
	}
	
	public double getDepositAmount() {
		return DEPOSIT_AMOUNT;
	}
	
	public double interestEarned() {
		return (DEPOSIT_AMOUNT * APY) * TERM;
	}
	
	public void redeem(Account whichAccount) {
		whichAccount.deposit(DEPOSIT_AMOUNT + this.interestEarned());
	}
}