package gui;
import buttons.*;
import control.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Office_GUI {

	monitor m;
	private JFrame frame;
	JTable table;
	Vector<Vector<String>> userData;
	
	ArrayList<SlotButton> slotBtnList=new ArrayList<SlotButton>();
	ArrayList<ScooterButton> scooterBtnList=new ArrayList<ScooterButton>();
	ArrayList<JLabel> labelList=new ArrayList<JLabel>();

	/**
	 * Launch the application by other classes
	 */
	public static void launcher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_GUI window = new Office_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application now.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Office_GUI window = new Office_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Office_GUI() {
		initialize();
		m = new monitor(this);
		m.start();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 982, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//all the labels of stations
		JLabel lblStationA = new JLabel("Station A");
		lblStationA.setForeground(new Color(0, 0, 0));
		lblStationA.setFont(new Font("Century", Font.BOLD, 16));
		lblStationA.setBackground(Color.PINK);
		lblStationA.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationA.setBounds(47, 27, 216, 61);
		frame.getContentPane().add(lblStationA);
		
		JLabel lblStationB = new JLabel("Station B");
		lblStationB.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationB.setForeground(Color.BLACK);
		lblStationB.setFont(new Font("Century", Font.BOLD, 16));
		lblStationB.setBackground(Color.PINK);
		lblStationB.setBounds(375, 15, 214, 84);
		frame.getContentPane().add(lblStationB);
		
		JLabel lblStationC = new JLabel("Station C");
		lblStationC.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationC.setForeground(Color.BLACK);
		lblStationC.setFont(new Font("Century", Font.BOLD, 16));
		lblStationC.setBackground(Color.PINK);
		lblStationC.setBounds(688, 15, 216, 84);
		frame.getContentPane().add(lblStationC);
		
		
		//all the slot buttons 
		SlotButton A1 = new SlotButton("1");
		slotBtnList.add(A1);
		A1.setBounds(47, 98, 46, 39);
		frame.getContentPane().add(A1);
		
		SlotButton A2 = new SlotButton("2");
		slotBtnList.add(A2);
		A2.setBounds(105, 98, 46, 39);
		frame.getContentPane().add(A2);
		
		SlotButton A3 = new SlotButton("3");
		slotBtnList.add(A3);
		A3.setBounds(161, 98, 46, 39);
		frame.getContentPane().add(A3);
		
		SlotButton A4 = new SlotButton("4");
		slotBtnList.add(A4);
		A4.setBounds(217, 98, 46, 39);
		frame.getContentPane().add(A4);
		
		SlotButton A5 = new SlotButton("5");
		slotBtnList.add(A5);
		A5.setBounds(47, 147, 46, 39);
		frame.getContentPane().add(A5);
		
		SlotButton A6 = new SlotButton("6");
		slotBtnList.add(A6);
		A6.setBounds(105, 147, 46, 39);
		frame.getContentPane().add(A6);
		
		SlotButton A7 = new SlotButton("7");
		slotBtnList.add(A7);
		A7.setBounds(161, 147, 46, 39);
		frame.getContentPane().add(A7);
		
		SlotButton A8 = new SlotButton("8");
		slotBtnList.add(A8);
		A8.setBounds(217, 147, 46, 39);
		frame.getContentPane().add(A8);
		
		SlotButton B1 = new SlotButton("9");
		slotBtnList.add(B1);
		B1.setBounds(375, 98, 46, 39);
		frame.getContentPane().add(B1);
		
		SlotButton B2 = new SlotButton("10");
		slotBtnList.add(B2);
		B2.setBounds(431, 98, 46, 39);
		frame.getContentPane().add(B2);
		
		SlotButton B3 = new SlotButton("11");
		slotBtnList.add(B3);
		B3.setBounds(487, 98, 46, 39);
		frame.getContentPane().add(B3);
		
		SlotButton B4 = new SlotButton("12");
		slotBtnList.add(B4);
		B4.setBounds(543, 98, 46, 39);
		frame.getContentPane().add(B4);
		
		SlotButton B5 = new SlotButton("13");
		slotBtnList.add(B5);
		B5.setBounds(375, 147, 46, 39);
		frame.getContentPane().add(B5);
		
		SlotButton B6 = new SlotButton("14");
		slotBtnList.add(B6);
		B6.setBounds(431, 147, 46, 39);
		frame.getContentPane().add(B6);
		
		SlotButton B7 = new SlotButton("15");
		slotBtnList.add(B7);
		B7.setBounds(487, 147, 46, 39);
		frame.getContentPane().add(B7);
		
		SlotButton B8 = new SlotButton("16");
		slotBtnList.add(B8);
		B8.setBounds(543, 147, 46, 39);
		frame.getContentPane().add(B8);
		
		SlotButton C1 = new SlotButton("17");
		slotBtnList.add(C1);
		C1.setBounds(688, 98, 46, 39);
		frame.getContentPane().add(C1);
		
		SlotButton C2 = new SlotButton("18");
		slotBtnList.add(C2);
		C2.setBounds(746, 98, 46, 39);
		frame.getContentPane().add(C2);
		
		SlotButton C3 = new SlotButton("19");
		slotBtnList.add(C3);
		C3.setBounds(802, 98, 46, 39);
		frame.getContentPane().add(C3);
		
		SlotButton C4 = new SlotButton("20");
		slotBtnList.add(C4);
		C4.setBounds(858, 98, 46, 39);
		frame.getContentPane().add(C4);
		
		SlotButton C5 = new SlotButton("21");
		slotBtnList.add(C5);
		C5.setBounds(688, 147, 46, 39);
		frame.getContentPane().add(C5);
		
		SlotButton C6 = new SlotButton("22");
		slotBtnList.add(C6);
		C6.setBounds(746, 147, 46, 39);
		frame.getContentPane().add(C6);
		
		SlotButton C7 = new SlotButton("23");
		slotBtnList.add(C7);
		C7.setBounds(802, 147, 46, 39);
		frame.getContentPane().add(C7);
		
		SlotButton C8 = new SlotButton("24");
		slotBtnList.add(C8);
		C8.setBounds(858, 147, 46, 39);
		frame.getContentPane().add(C8);
		
		JLabel lblStation = new JLabel("STATION");
		lblStation.setFont(new Font("Century", Font.BOLD, 16));
		lblStation.setBounds(10, 10, 94, 28);
		frame.getContentPane().add(lblStation);
		
		JLabel lblScooter = new JLabel("SCOOTER");
		lblScooter.setFont(new Font("Century", Font.BOLD, 16));
		lblScooter.setBounds(10, 219, 94, 28);
		frame.getContentPane().add(lblScooter);
		
		//all the scooters
		ScooterButton btnNewButton_1 = new ScooterButton("1");
		scooterBtnList.add(btnNewButton_1);
		btnNewButton_1.setBounds(47, 254, 46, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		ScooterButton m_scooter_1 = new ScooterButton("2");
		scooterBtnList.add(m_scooter_1);
		m_scooter_1.setBounds(171, 254, 46, 39);
		frame.getContentPane().add(m_scooter_1);
		
		ScooterButton m_scooter_10 = new ScooterButton("3");
		scooterBtnList.add(m_scooter_10);
		m_scooter_10.setBounds(296, 254, 46, 39);
		frame.getContentPane().add(m_scooter_10);
		
		ScooterButton m_scooter_4 = new ScooterButton("4");
		scooterBtnList.add(m_scooter_4);
		m_scooter_4.setBounds(413, 254, 46, 39);
		frame.getContentPane().add(m_scooter_4);
		
		ScooterButton m_scooter_3 = new ScooterButton("5");
		scooterBtnList.add(m_scooter_3);
		m_scooter_3.setBounds(543, 254, 46, 39);
		frame.getContentPane().add(m_scooter_3);
		
		ScooterButton m_scooter = new ScooterButton("6");
		scooterBtnList.add(m_scooter);
		m_scooter.setBounds(47, 332, 46, 39);
		frame.getContentPane().add(m_scooter);
		
		ScooterButton m_scooter_8 = new ScooterButton("7");
		scooterBtnList.add(m_scooter_8);
		m_scooter_8.setBounds(171, 332, 46, 39);
		frame.getContentPane().add(m_scooter_8);
		
		ScooterButton m_scooter_11 = new ScooterButton("8");
		scooterBtnList.add(m_scooter_11);
		m_scooter_11.setBounds(296, 332, 46, 39);
		frame.getContentPane().add(m_scooter_11);
		
		ScooterButton m_scooter_5 = new ScooterButton("9");
		scooterBtnList.add(m_scooter_5);
		m_scooter_5.setBounds(413, 332, 46, 39);
		frame.getContentPane().add(m_scooter_5);
		
		ScooterButton m_scooter_9 = new ScooterButton("10");
		scooterBtnList.add(m_scooter_9);
		m_scooter_9.setBounds(543, 332, 46, 39);
		frame.getContentPane().add(m_scooter_9);
		
		ScooterButton m_scooter_7 = new ScooterButton("11");
		scooterBtnList.add(m_scooter_7);
		m_scooter_7.setBounds(47, 425, 46, 39);
		frame.getContentPane().add(m_scooter_7);
		
		
		ScooterButton m_scooter_2 = new ScooterButton("12");
		scooterBtnList.add(m_scooter_2);
		m_scooter_2.setBounds(171, 425, 46, 39);
		frame.getContentPane().add(m_scooter_2);
		
		

		
		
		
		ScooterButton m_scooter_12 = new ScooterButton("13");
		scooterBtnList.add(m_scooter_12);
		m_scooter_12.setBounds(296, 425, 46, 39);
		frame.getContentPane().add(m_scooter_12);
		
		ScooterButton m_scooter_13 = new ScooterButton("14");
		scooterBtnList.add(m_scooter_13);
		m_scooter_13.setBounds(413, 425, 46, 39);
		frame.getContentPane().add(m_scooter_13);
		

		ScooterButton m_scooter_6 = new ScooterButton("15");
		scooterBtnList.add(m_scooter_6);
		m_scooter_6.setBounds(543, 425, 46, 39);
		frame.getContentPane().add(m_scooter_6);
		
		//label
		//label
		JLabel label1 = new JLabel("");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		labelList.add(label1);
		label1.setFont(new Font("Century", Font.ITALIC, 14));
		label1.setBounds(35, 295, 79, 27);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		labelList.add(label2);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Century", Font.ITALIC, 14));
		label2.setBounds(155, 295, 79, 27);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("");
		labelList.add(label3);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Century", Font.ITALIC, 14));
		label3.setBounds(283, 295, 79, 27);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("");
		labelList.add(label4);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font("Century", Font.ITALIC, 14));
		label4.setBounds(398, 295, 79, 27);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("");
		labelList.add(label5);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Century", Font.ITALIC, 14));
		label5.setBounds(529, 295, 79, 27);
		frame.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("");
		labelList.add(label6);
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font("Century", Font.ITALIC, 14));
		label6.setBounds(35, 381, 79, 27);
		frame.getContentPane().add(label6);
		
		JLabel label7 = new JLabel("");
		labelList.add(label7);
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setFont(new Font("Century", Font.ITALIC, 14));
		label7.setBounds(161, 381, 79, 27);
		frame.getContentPane().add(label7);
		
		JLabel label8 = new JLabel("");
		labelList.add(label8);
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setFont(new Font("Century", Font.ITALIC, 14));
		label8.setBounds(283, 381, 79, 27);
		frame.getContentPane().add(label8);
		
		JLabel label9 = new JLabel("");
		labelList.add(label9);
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setFont(new Font("Century", Font.ITALIC, 14));
		label9.setBounds(398, 381, 79, 27);
		frame.getContentPane().add(label9);
		
		JLabel label10 = new JLabel("");
		labelList.add(label10);
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setFont(new Font("Century", Font.ITALIC, 14));
		label10.setBounds(529, 381, 79, 27);
		frame.getContentPane().add(label10);
		
		JLabel label11 = new JLabel("");
		labelList.add(label11);
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setFont(new Font("Century", Font.ITALIC, 14));
		label11.setBounds(25, 467, 79, 27);
		frame.getContentPane().add(label11);
		
		JLabel label12 = new JLabel("");
		labelList.add(label12);
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setFont(new Font("Century", Font.ITALIC, 14));
		label12.setBounds(161, 467, 79, 27);
		frame.getContentPane().add(label12);
		
		JLabel label13 = new JLabel("");
		labelList.add(label13);
		label13.setHorizontalAlignment(SwingConstants.CENTER);
		label13.setFont(new Font("Century", Font.ITALIC, 14));
		label13.setBounds(283, 467, 79, 27);
		frame.getContentPane().add(label13);
		
		JLabel label14 = new JLabel("");
		labelList.add(label14);
		label14.setHorizontalAlignment(SwingConstants.CENTER);
		label14.setFont(new Font("Century", Font.ITALIC, 14));
		label14.setBounds(398, 467, 79, 27);
		frame.getContentPane().add(label14);
		
		JLabel label15 = new JLabel("");
		labelList.add(label15);
		label15.setHorizontalAlignment(SwingConstants.CENTER);
		label15.setFont(new Font("Century", Font.ITALIC, 14));
		label15.setBounds(529, 467, 79, 27);
		frame.getContentPane().add(label15);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Century", Font.BOLD, 16));
		lblUser.setBounds(611, 219, 94, 28);
		frame.getContentPane().add(lblUser);
		
		JTextField userID = new JTextField(); // make a text field
		frame.getContentPane().add(userID);
		userID.setBounds(685, 490, 120, 30);
		
		JButton b =new JButton("SEND EMAIL");
		b.setFont(new Font("Century", Font.BOLD, 10));
		b.setBounds(805, 490, 130, 30);
		frame.getContentPane().add(b);
		
		b.addActionListener(new ActionListener() { // listen the button events
			public void actionPerformed(ActionEvent e) {
				String t1 = userID.getText();
				int i = Integer.parseInt(t1);
				SendEmail.sendEmail(i);
			}
		});
		
		//表格部分！
		//测试数据
		Vector<String> list1=new Vector<String>();
		list1.addElement("123");
		list1.addElement("hdvh");
		list1.addElement("free");
		
		userData = new Vector<Vector<String>>();
		userData.addElement(list1);
		
		//set the table header
		Vector<String> columnNames=new Vector<String>();
		columnNames.addElement("ID");
		columnNames.addElement("Name");
		columnNames.addElement("Status");
		
		table = new JTable(userData,columnNames){
            public boolean isCellEditable(int row, int column)
            {
            	return false;
            }//the table can't be exited
        };
        table.getTableHeader().setReorderingAllowed(false);
		
		//add a sliding pane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(688, 257, 247, 223);
		frame.getContentPane().add(scrollPane);
	}
}
