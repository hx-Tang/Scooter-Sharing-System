package control;

import java.util.ArrayList;

import db.DBImpl;
import storage.Order;
import storage.Scooter;
import storage.Slot;
import storage.Station;
import storage.User;

public class DropOff {
	/**
	 * this class provide a function as returning the scooter
	 */
	// isFull whether station is full
	public static int isFull(Station station) {
		// return an empty slot id,-1 represent no available slot

		ArrayList<Slot> slots = station.getSlots();
		int EmptySlot = -1;

		for (Slot slot : slots) {
			if (slot.getStatus() == 0) {
				EmptySlot = slot.getId();
				break;
			}
		}

		return EmptySlot;
	}

	// dropOff
	public static void dropOff(int userid, int slotid, int scooterid, int endstationID) {
		DBImpl db = new DBImpl();
		User user = db.getUser(userid);
		Order order = db.getOrderbyUser(userid);// obtain the latest order of user
		String start = order.getInittime();
		String end = Util.getTime();
		int timeSpend = Util.timeSlot(start, end);
		
		// return scooter
		Station station = db.getStation(endstationID);
		ArrayList<Slot> slots = station.getSlots();
		for (Slot slot : slots) {
			if (slot.getId() == slotid) {
				Scooter scooter = db.getScooter(scooterid);
				scooter.setStatus(0);//change scooter status after returning it .
				db.setScooter(scooter);
				slot.setStatus(scooter.getId());
				// check whether time exceeds 30 minutes.
				if (timeSpend > 1) {
					// change user status to pay fine state.
					user.setStatus(-1);
					Util.display("you have been blocked!");
				} else {
					user.setStatus(0);
				}
				break;
			}
		}
		// save user,complete the end station and end time of order .
		db.setStation(station);
		db.setUser(user);
		order.setEndstation(endstationID);
		order.setEndtime(end);
		db.setOrder(order);
	}

	// check whether the total time of user's orders exceed 120 minutes.
	public void payFine(int userid) {
		DBImpl db = new DBImpl();
		User user = db.getUser(userid);
		ArrayList<Order> orders = db.getOrderbyUserAll(userid);
		int totalTimeSpend = 0;
		int timeSl = 0;
		for (Order o : orders) {
			String st = o.getInittime();
			String et = o.getEndtime();
			timeSl = Util.timeSlot(st, et);
			totalTimeSpend += timeSl;
		}
		if (totalTimeSpend > 2) {
			// change user status to pay fine state.
			user.setStatus(-1);
			System.out.println("pay fine");
		} else {
			System.out.println("good");
			
		}
	}

}
