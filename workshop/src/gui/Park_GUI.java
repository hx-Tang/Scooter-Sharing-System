package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import storage.Slot;
import buttons.*;
import db.DBImpl;

public class Park_GUI {
	ArrayList<SlotButton> slotBtnList=new ArrayList<SlotButton>();
	ArrayList<ScanButton> scanBtnList=new ArrayList<ScanButton>();
	ArrayList<ScooterButton> scooterBtnList=new ArrayList<ScooterButton>();
	private JFrame frmParkingLotgui;

	/**
	 * Launch the application by other classes
	 */
	public static void launcher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Park_GUI window = new Park_GUI();
					window.frmParkingLotgui.setVisible(true);
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
					Park_GUI window = new Park_GUI();
					window.frmParkingLotgui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Park_GUI() {
		
		initialize();
		DBImpl db = new DBImpl();
		ArrayList<Slot> Slotlist = db.getSlotAll();
		for(int i = 0;i<Slotlist.size();i++) {//change the btn content
			slotBtnList.get(i).setContent(Slotlist.get(i));
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmParkingLotgui = new JFrame();
		frmParkingLotgui.setTitle("parking lot_GUI");
		frmParkingLotgui.setBounds(150, 150, 961, 543);
		frmParkingLotgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmParkingLotgui.getContentPane().setLayout(null);
		//all the horizontal box
		//box1
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setFont(new Font("Dialog", Font.PLAIN, 16));
		horizontalBox.setBorder(new LineBorder(Color.PINK, 3, true));
		horizontalBox.setBackground(Color.WHITE);
		horizontalBox.setBounds(323, 56, 234, 77);
		frmParkingLotgui.getContentPane().add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Docking station A\r\n");
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 17));
		horizontalBox.add(lblNewLabel);
		//box2
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		horizontalBox_1.setBorder(new LineBorder(Color.PINK, 3, true));
		horizontalBox_1.setBackground(Color.WHITE);
		horizontalBox_1.setBounds(43, 256, 234, 77);
		frmParkingLotgui.getContentPane().add(horizontalBox_1);
		
		JLabel lblDockingStationB = new JLabel("Docking station B");
		lblDockingStationB.setFont(new Font("Century", Font.BOLD, 17));
		horizontalBox_1.add(lblDockingStationB);
		//box3
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		horizontalBox_2.setBorder(new LineBorder(Color.PINK, 3, true));
		horizontalBox_2.setBackground(Color.WHITE);
		horizontalBox_2.setBounds(573, 256, 234, 77);
		frmParkingLotgui.getContentPane().add(horizontalBox_2);
		
		JLabel lblDockingStationC = new JLabel("Docking station C");
		lblDockingStationC.setFont(new Font("Century", Font.BOLD, 17));
		horizontalBox_2.add(lblDockingStationC);
		
		
		//all the scan buttons
		ScanButton ScanA = new ScanButton("Scan",1,slotBtnList);
		ScanA.setBounds(573, 56, 82, 36);
		frmParkingLotgui.getContentPane().add(ScanA);
		
		ScanButton ScanB = new ScanButton("Scan",2,slotBtnList);
		ScanB.setBounds(293, 256, 82, 36);
		frmParkingLotgui.getContentPane().add(ScanB);
		
		ScanButton ScanC = new ScanButton("Scan",3,slotBtnList);
		ScanC.setBounds(823, 256, 82, 36);
		frmParkingLotgui.getContentPane().add(ScanC);
		
		
		//all the slot buttons
		SlotButton A1 = new SlotButton("1");
		slotBtnList.add(A1);
		A1.setBounds(324, 143, 51, 36);
		frmParkingLotgui.getContentPane().add(A1);

		SlotButton A2 = new SlotButton("2");
		slotBtnList.add(A2);
		A2.setBounds(385, 143, 51, 36);
		frmParkingLotgui.getContentPane().add(A2);
		
		SlotButton A3 = new SlotButton("3");
		slotBtnList.add(A3);
		A3.setBounds(446, 143, 51, 36);
		frmParkingLotgui.getContentPane().add(A3);
		
		SlotButton A4 = new SlotButton("4");
		slotBtnList.add(A4);
		A4.setBounds(507, 143, 51, 36);
		frmParkingLotgui.getContentPane().add(A4);
		
		SlotButton A5 = new SlotButton("5");
		slotBtnList.add(A5);
		A5.setBounds(323, 189, 51, 36);
		frmParkingLotgui.getContentPane().add(A5);
		
		SlotButton A6 = new SlotButton("6");
		slotBtnList.add(A6);
		A6.setBounds(385, 189, 51, 36);
		frmParkingLotgui.getContentPane().add(A6);
		
		SlotButton A7 = new SlotButton("7");
		slotBtnList.add(A7);
		A7.setBounds(446, 189, 51, 36);
		frmParkingLotgui.getContentPane().add(A7);
		
		SlotButton A8 = new SlotButton("8");
		slotBtnList.add(A8);
		A8.setBounds(507, 189, 51, 36);
		frmParkingLotgui.getContentPane().add(A8);
		
		SlotButton B1 = new SlotButton("9");
		slotBtnList.add(B1);
		B1.setBounds(44, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(B1);
		
		SlotButton B2 = new SlotButton("10");
		slotBtnList.add(B2);
		B2.setBounds(105, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(B2);
		
		SlotButton B3 = new SlotButton("11");
		slotBtnList.add(B3);
		B3.setBounds(166, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(B3);
		
		SlotButton B4 = new SlotButton("12");
		slotBtnList.add(B4);
		B4.setBounds(227, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(B4);
		
		SlotButton B5 = new SlotButton("13");
		slotBtnList.add(B5);
		B5.setBounds(43, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(B5);
		
		SlotButton B6 = new SlotButton("14");
		slotBtnList.add(B6);
		B6.setBounds(105, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(B6);
		
		SlotButton B7 = new SlotButton("15");
		slotBtnList.add(B7);
		B7.setBounds(166, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(B7);
		
		SlotButton B8 = new SlotButton("16");
		slotBtnList.add(B8);
		B8.setBounds(227, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(B8);
		
		
		SlotButton C1 = new SlotButton("17");
		slotBtnList.add(C1);
		C1.setBounds(574, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(C1);
		
		SlotButton C2 = new SlotButton("18");
		slotBtnList.add(C2);
		C2.setBounds(635, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(C2);
		
		SlotButton C3 = new SlotButton("19");
		slotBtnList.add(C3);
		C3.setBounds(696, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(C3);
		
		SlotButton C4 = new SlotButton("20");
		slotBtnList.add(C4);
		C4.setBounds(757, 343, 51, 36);
		frmParkingLotgui.getContentPane().add(C4);
		
		SlotButton C5 = new SlotButton("21");
		slotBtnList.add(C5);
		C5.setBounds(573, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(C5);
		
		SlotButton C6 = new SlotButton("22");
		slotBtnList.add(C6);
		C6.setBounds(635, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(C6);
		
		SlotButton C7 = new SlotButton("23");
		slotBtnList.add(C7);
		C7.setBounds(696, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(C7);
		
		SlotButton C8 = new SlotButton("24");
		slotBtnList.add(C8);
		C8.setBounds(757, 389, 51, 36);
		frmParkingLotgui.getContentPane().add(C8);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBounds(56, 100, 39, -43);
		frmParkingLotgui.getContentPane().add(horizontalBox_3);
		
		JLabel lblNewLabel_1 = new JLabel("User Center");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setBounds(38, 30, 136, 54);
		frmParkingLotgui.getContentPane().add(lblNewLabel_1);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User_GUI.user_ui();
			}
		});
		btnEnter.setBackground(Color.CYAN);
		btnEnter.setFont(new Font("Century", Font.PLAIN, 16));
		btnEnter.setBounds(48, 100, 93, 23);
		frmParkingLotgui.getContentPane().add(btnEnter);
		
		

	}
}
