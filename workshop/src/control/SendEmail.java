package control;

import java.util.ArrayList;

import db.DBImpl;
import storage.Order;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SendEmail {
	public static void sendEmail(int userid) {
		JFrame myFrame = new JFrame("Feedback Email"); // make a frame
		myFrame.setLayout(null);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lab1 = new JLabel("              Your using profile in last 7 days is following：\n");
		myFrame.getContentPane().add(lab1);
		lab1.setBounds(120, 20, 500, 20);

		JLabel lab2 = new JLabel("  Initial Station     Initial Time     End Station       End Time      Using Time");
		myFrame.getContentPane().add(lab2);
		lab2.setBounds(60, 70, 500, 20);

		JLabel lab4 = new JLabel(
				"                Your account is not available now. Please pay fines and continue to use. ");
		myFrame.getContentPane().add(lab4);
		lab4.setBounds(30, 300, 600, 20);
		lab4.setVisible(false);

		JPanel jp = new JPanel();
		myFrame.getContentPane().add(jp);
		jp.setBounds(40, 90, 600, 150);
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));

		myFrame.setSize(630, 400); // set the size and location of the frame
		myFrame.setLocation(400, 200);
		myFrame.setVisible(true);

		int c;// time difference.
		String a = Util.getTime(); // current time

		DBImpl DB = new DBImpl();
		ArrayList<Order> order = DB.getOrderbyUserAll(userid);

		int tt = 0;

		for (int i = 0; i < order.size();) {
			Order d = order.get(i);
			String t = d.getInittime();
			c = Util.timeSlot(t, a); // compute the time difference between current order.
			int tc = Util.timeSlot(d.getInittime(), d.getEndtime());
			i++;

			if (c <= 10080)// check the time difference ,compared it with 7 days.
			{	
				//change the station name to letter. 
				jp.add(new JLabel(i + "          " + Util.parseStation(d.getInitstation()) + "              " + d.getInittime() + "       "
						+ Util.parseStation(d.getEndstation()) + "          " + d.getEndtime() + "      " + tc + "\n\n"));
				tt = tt + tc;
			}

		}

		JLabel lab3 = new JLabel("                      Your total using time in last 7 days is：" + tt + "minutes");
		myFrame.getContentPane().add(lab3);
		lab3.setBounds(85, 280, 500, 20);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
			}
		});
		myFrame.getContentPane().add(btnBack);
		
		if (PayFine.isblocked(userid))//re-used
			lab4.setVisible(true);

	}
}
