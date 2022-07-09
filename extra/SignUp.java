package extra;
import java.util.Scanner;

import tools.Password;
import user.BankUser;

public class SignUp implements Runnable {
	private String tempUsername, tempPassword;
	private String tempQuestion, tempAnswer;
	private String[] questions = {"In what city were you born?",
								  "What is the name of your favorite pet?",
								  "What is your mother's maiden name?",
								  "What high school did you attend?",
								  "What is the name of your first school?",
								  "What was the make of your first car?",
								  "What was your favorite food as a child?"};

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("What would you like your username to be? Please enter below:");
		System.out.print("Enter here: ");
		tempUsername = scanner.nextLine();
		
		System.out.println();
		
		System.out.println("Now, a password will be generated for you\n");
		tempPassword = Password.generatePassword();
		
		System.out.println("Please select a security question below\n");
		
		int counter = 1;
		for (String question : questions) {
			System.out.println(counter + ". " + question);
			counter++;
		}
		
		System.out.println();
		
		System.out.print("Enter number here: ");
		tempQuestion = questions[scanner.nextInt() - 1];
		scanner.nextLine();
		
		System.out.println();
		
		System.out.println("What is the answer to your selected question?");
		System.out.print("Enter here: ");
		tempAnswer = scanner.nextLine();
		
		System.out.println();
		
		BankUser user = new BankUser(tempUsername, tempPassword, tempQuestion, tempAnswer);
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getSecurityQuestion());
		System.out.println(user.getSecurityAnswer());
		
		scanner.close();
	}
}
