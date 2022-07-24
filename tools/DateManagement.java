package tools;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class DateManagement {
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	
	private static Calendar cal = Calendar.getInstance();
	private static int year = cal.get(Calendar.YEAR);
	private static int month = cal.get(Calendar.MONTH);
	private static int day = cal.get(Calendar.DAY_OF_MONTH);
	
	private static GregorianCalendar currentDate = new GregorianCalendar(year, month, day);
	private static GregorianCalendar expirationDate, manualDate;
	
	public static int getYear() {
		return year;
	}
	
	public static int getMonth() {
		return month;
	}
	
	public static int getDay() {
		return day;
	}
	
	public static GregorianCalendar getCurrentDate() {
		return currentDate;
	}
	
	public static GregorianCalendar setExpirationDate(String when, int howMany) {
		switch(when) {
			case "year": expirationDate = new GregorianCalendar(year + howMany, month, day);
			break;
			case "month":
				if ((month + howMany) > 11) {
					expirationDate = new GregorianCalendar(year + 1, howMany - 1, day);
				} else {
					expirationDate = new GregorianCalendar(year, month + howMany, day);
				}
			break;
			case "day":
				if (((day + howMany) > 30) && (month == 11)) {
					expirationDate = new GregorianCalendar(year + 1, 0, (day + howMany) - 30);
				} else if ((day + howMany) > 30) {
					expirationDate = new GregorianCalendar(year, month + 1, (day + howMany) - 30);
				} else {
					expirationDate = new GregorianCalendar(year, month, day + howMany);
				}
			break;
		}
		return expirationDate;
	}

	public static GregorianCalendar getExpirationDate(String when, int howMany) {
		return setExpirationDate(when, howMany);
	}
	
	public static GregorianCalendar getExpirationDate() {
		return expirationDate;
	}
	
	public static GregorianCalendar setManualDate(int whatYear, int whatMonth, int whatDay) {
		manualDate = new GregorianCalendar(whatYear, whatMonth, whatDay);
		return manualDate;
	}

	public static GregorianCalendar getManualDate(int whatYear, int whatMonth, int whatDay) {
		return setManualDate(whatYear, whatMonth, whatDay);
	}
	
	public static GregorianCalendar getManualDate() {
		return manualDate;
	}
	
	public static String getFormattedDate(GregorianCalendar date) {
		return sdf.format(date.getTime());
	}
}
