package cards;
import java.io.Serializable;
import java.util.Random;

import tools.DateManagement;

public abstract class Card implements Serializable {
	private static final long serialVersionUID = 6;
	protected final long CARD_NUMBER;
	protected final String EXPIRATION_DATE, CVV, PIN;
	
	public Card() {
		Random rand = new Random();
		CARD_NUMBER = Math.abs(rand.nextLong());
		
		EXPIRATION_DATE = findExpirationDate();

		CVV = generateCVV();

		PIN = generatePIN();
	}

	private String generateCVV() {
		Random rand = new Random();
		Integer randCVV = rand.nextInt(1000);
		if (randCVV >= 100) {
			return randCVV.toString();
		} else {
			return String.format("%03d", randCVV);
		}
	}

	private String generatePIN() {
		Random rand = new Random();
		Integer randPIN = rand.nextInt(10000);
		if (randPIN >= 1000) {
			return randPIN.toString();
		} else {
			return String.format("%04d", randPIN);
		}
	}
	
	private String findExpirationDate() {
		return DateManagement.getFormattedDate(DateManagement.getExpirationDate("year", 5));
	}
	
	public long getCardNumber() {
		return CARD_NUMBER;
	}
	
	public String getExpirationDate() {
		return EXPIRATION_DATE;
	}
	
	public String getCVV() {
		return CVV;
	}
	
	public String getPIN() {
		return PIN;
	}
	
	public boolean isExpired() {
		return DateManagement.getCurrentDate().after(DateManagement.getExpirationDate());
	}
	
}
