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
		
		Integer randCVV = rand.nextInt(1000);
		if (randCVV >= 100) {
			CVV = randCVV.toString();
		} else {
			CVV = String.format("%03d", randCVV);
		}
		
		Integer randPIN = rand.nextInt(10000);
		if (randPIN >= 1000) {
			PIN = randPIN.toString();
		} else {
			PIN = String.format("%04d", randPIN);
		}
	}
	
	private String findExpirationDate() {
		DateManagement.setExpirationDate("year", 5);
		return DateManagement.getFormattedDate(DateManagement.getExpirationDate());
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
