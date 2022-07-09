package tools;
import java.nio.charset.Charset;
import java.util.Random;

public class Password {
	public static String generatePassword() {
		byte[] arr = new byte[8];
		new Random().nextBytes(arr);
		
		String generatedString = new String(arr, Charset.forName("UTF-8"));
		return generatedString;
	}
}
