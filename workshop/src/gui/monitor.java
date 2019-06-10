package gui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import buttons.ScooterButton;
import buttons.SlotButton;
import db.DBImpl;
import storage.Scooter;
import storage.Slot;
import storage.User;

//Refresher thread
public class monitor extends Thread{
	DBImpl db = new DBImpl();
	ArrayList<SlotButton> SlotbtnList;
	ArrayList<ScooterButton> ScooterbtnList;
	ArrayList<JLabel> Scooterlabellist;
	
	Vector<Vector<String>> UserData;
	JTable Table;
	
	//Refresher constructor
	public monitor(Office_GUI gui) {
		super();
		SlotbtnList = gui.slotBtnList;
		ScooterbtnList = gui.scooterBtnList;
		Scooterlabellist = gui.labelList;
		UserData = gui.userData;
		Table = gui.table;
	}

	//Refresh content
	public void run() {
		while(true) {
			//read all scooters' information
			ArrayList<Scooter> Scooterlist = db.getScooterAll();
			for(int i = 0;i<Scooterlist.size();i++) {//一对一更改btn内容
				ScooterbtnList.get(i).setContent(Scooterlist.get(i), Scooterlabellist.get(i));
			}
			
			//read all stations' information
			ArrayList<Slot> Slotlist = db.getSlotAll();
			for(int i = 0;i<Slotlist.size();i++) {//一对一更改btn内容
				SlotbtnList.get(i).setContent(Slotlist.get(i));
			}
			
			//read all users' information
			UserData.clear();
			ArrayList<User> Userlist = db.getUserAll();
			for(int i = 0;i<Userlist.size();i++) {//一对一更改btn内容
				Vector<String> list=new Vector<String>();
				list.addElement(""+Userlist.get(i).getId());
				list.addElement(""+Userlist.get(i).getName());
				if(Userlist.get(i).getStatus()==0)
					list.addElement("free");
				else if(Userlist.get(i).getStatus()==-1)
					list.addElement("blocked");
				else list.addElement(""+Userlist.get(i).getStatus());
				UserData.add(list);
			}
			Table.validate();
			Table.updateUI();
			
			//refresh every second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 
				e.printStackTrace();
			}
		}
	}
	
}
