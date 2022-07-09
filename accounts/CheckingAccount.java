package accounts;
import cards.DebitCard;

public class CheckingAccount extends Account {
	private static final long serialVersionUID = 3;
	private DebitCard debitCard;
	
	public CheckingAccount(double initialAmount, String accountName) {
		super(initialAmount, accountName);
	}
	
	public void activateDebitCard() {
		debitCard = new DebitCard();
	}
	
	public DebitCard getDebitCard() {
		return debitCard;
	}
}
