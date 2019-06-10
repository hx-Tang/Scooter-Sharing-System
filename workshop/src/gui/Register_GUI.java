package gui;

import javax.swing.JFrame;

import control.*;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class Register_GUI {

	public static void register() {
		JFrame myFrame = new JFrame("Register"); // make a frame
		myFrame.getContentPane().setLayout(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton myButton1 = new JButton("Register"); // go to register function
		myButton1.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		myFrame.getContentPane().add(myButton1);
		myButton1.setBounds(138, 300, 100, 30);

		JButton myButton2 = new JButton("Cancel"); // go back to the previous interface
		myButton2.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		myFrame.getContentPane().add(myButton2);
		myButton2.setBounds(325, 300, 100, 30);
		myButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
			}
		});

		JTextField field1 = new JTextField(); // make a text field
		// field1.setDocument(new limit(3));
		myFrame.getContentPane().add(field1);
		field1.setBounds(280, 89, 200, 30);

		JTextField field2 = new JTextField(); // make a text field
		// field1.setDocument(new limit(3));
		myFrame.getContentPane().add(field2);
		field2.setBounds(280, 167, 200, 30);

		JTextField field3 = new JTextField(); // make a text field
		// field1.setDocument(new limit(3));
		myFrame.getContentPane().add(field3);
		field3.setBounds(280, 237, 200, 30);

		JLabel lab1 = new JLabel("Please fill in the following information for registration."); // make a label for
																								// question
		lab1.setFont(new Font("Century", Font.BOLD, 16));
		myFrame.getContentPane().add(lab1);
		lab1.setBounds(54, 10, 500, 59);

		JLabel lab2 = new JLabel("Your QM ID: "); // make a label to display the correct answer and inform users the
													// answer is correct or wrong
		lab2.setFont(new Font("Century", Font.PLAIN, 16));
		myFrame.getContentPane().add(lab2);
		lab2.setBounds(74, 92, 141, 40);

		JLabel lab4 = new JLabel("Your email address: "); // error report
		lab4.setFont(new Font("Century", Font.PLAIN, 16));
		myFrame.getContentPane().add(lab4);
		lab4.setBounds(74, 237, 168, 30);

		JLabel lblYourName = new JLabel("Your name");
		lblYourName.setFont(new Font("Century", Font.PLAIN, 16));
		lblYourName.setBounds(74, 160, 168, 40);
		myFrame.getContentPane().add(lblYourName);

		myFrame.setSize(600, 400); // set the size and location of the frame
		myFrame.setLocation(400, 200);
		myFrame.setVisible(true);

		myButton1.addActionListener(new ActionListener() { // listen the button events
			public void actionPerformed(ActionEvent e) {
				String t1 = field1.getText();
				String t2 = field2.getText();
				String t3 = field3.getText();
				if (Register.verifyInfo(t1, t2, t3)) {
					int i = Integer.parseInt(t1);
					Register.register(i, t2, t3);
					myFrame.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null,
							"The format of information that you entered is wrong.\n \n          Please check the format and enter again. ",
							"Format Error", JOptionPane.PLAIN_MESSAGE);
				}

				field1.grabFocus(); // focus on text field
				field1.setText(""); // clear the text
				field2.setText("");
				field3.setText("");
			}
		});

		

	}

}
