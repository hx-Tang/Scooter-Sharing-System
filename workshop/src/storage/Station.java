package storage;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import org.dom4j.Node;

public class Station {
	private int id;
	private ArrayList<Slot> slots; // the arraylist be used to store slot information

	public Station(char id, ArrayList<Slot> slots) {
		super();
		this.id = id;
		this.slots = slots;
	}

	public Station() {
		// TODO 
	}

	public String toString() {
		String res = "";
		for (Iterator<Slot> iter = slots.iterator(); iter.hasNext();) {
			Slot slot = iter.next();
			res += "\nslot=" + slot.getId() + "\nstatus=" + slot.getStatus();
		}
		return "\nstationid=" + id + res;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return slots
	 */
	public ArrayList<Slot> getSlots() {
		return slots;
	}

	/**
	 * @param slots
	 *            
	 */
	public void setSlots(ArrayList<Slot> slots) {
		this.slots = slots;
	}
	
}
