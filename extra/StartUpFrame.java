package extra;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartUpFrame extends JFrame implements ActionListener {
	JButton logInButton, signUpButton;
	JLabel welcome;
	
	public StartUpFrame() {
		welcome = new JLabel();
		welcome.setText("Welcome to ZBank!");
		welcome.setIcon(getEmptyIcon());
		welcome.setHorizontalTextPosition(JLabel.CENTER);
		welcome.setVerticalTextPosition(JLabel.BOTTOM);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setVerticalAlignment(JLabel.TOP);
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		logInButton = new JButton();
		logInButton.setBounds(25, 250, 200, 100);
		logInButton.addActionListener(this); //lambda expression - (e -> *what to do*)
		logInButton.setText("Log In");
		logInButton.setFocusable(false);
		logInButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		signUpButton = new JButton();
		signUpButton.setBounds(250, 250, 200, 100);
		signUpButton.addActionListener(this);
		signUpButton.setText("Sign Up");
		signUpButton.setFocusable(false);
		signUpButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		this.setTitle("ZBank StartUp");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(500, 500);
		this.setVisible(true);
		
		ImageIcon image = new ImageIcon("GoldZ.jpg");
		this.setIconImage(image.getImage());
		
		this.getContentPane().setBackground(Color.green);
		
		this.add(logInButton);
		this.add(signUpButton);
		this.add(welcome);	
	}
	
	private Icon getEmptyIcon() {
		BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		return new ImageIcon(bufferedImage);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logInButton) {
			System.out.println("log in");
		} else if (e.getSource() == signUpButton) {
			System.out.println("sign up");
		}
	}
}
