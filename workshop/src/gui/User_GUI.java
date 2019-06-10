package gui;

import javax.swing.JFrame;

import control.*;

import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Font;

public class User_GUI {
	static JFrame myFrame = new JFrame("Register");  // make a frame
	public static void user_ui() {
		launcher();
	}
	
	public static void launcher() {
		myFrame.setTitle("User_GUI");
		myFrame.getContentPane().setLayout(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton myButton1 = new JButton("Register"); //go to register 
		myButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_GUI.register();
			}
		});
		myButton1.setFont(new Font("Century", Font.BOLD, 16));
		myFrame.getContentPane().add(myButton1);
		myButton1.setBounds(195,55,190,61);
		
		JButton myButton2 = new JButton("Pay fine"); 
		myButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Util.Scan();
				if (userid>0) {
					if(PayFine.verifyFine(userid)) {
						PayFine.payfine(userid);
						Util.display("Success!");
					}
				}
			}
		});
		myButton2.setFont(new Font("Century", Font.BOLD, 16));
		myFrame.getContentPane().add(myButton2);
		myButton2.setBounds(195,168,190,61);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Century", Font.PLAIN, 16));
		btnBack.setBounds(219, 277, 136, 29);
		myFrame.getContentPane().add(btnBack);

		 
		myFrame.setSize(600,400);  // set the size and location of the frame
		myFrame.setLocation(400,200);
		myFrame.setVisible(true); 
		
	}

}
