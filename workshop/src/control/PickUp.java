package control;

import java.util.ArrayList;

import db.DBImpl;
import storage.Order;
import storage.Scooter;
import storage.Slot;
import storage.Station;
import storage.User;

/**
 * this class provide the function of picking up scooter.
 */
public class PickUp {
	// isEmpty-check whether the station has available scooters.
	public static int isEmpty(Station station) {
		//  return an slot id with scooter,-1 represent no available scooter.
		ArrayList<Slot> slots = station.getSlots();
		int slotid = -1;

		for (Slot slot : slots) {
			if (slot.getStatus() != 0) {
				slotid = slot.getId();
				break;
			}
		}

		return slotid;
	}

	// pick up
	public static void pickUp(int userid, int slotid, int scooterid, int initstationID) {
		DBImpl db = new DBImpl();
		String inittime = Util.getTime();

		// obtain slot id and scooter id .
		Station station = db.getStation(initstationID);
		ArrayList<Slot> slots = station.getSlots();
		for (Slot slot : slots) {
			if (slot.getId() == slotid) {
				scooterid = slot.getStatus();
				slot.setStatus(0);
				break;
			}
		}
		db.setStation(station);

		// message window
		Util.display("pickup scooter No." + scooterid + " at slot No." + slotid);
		
		// scooter
		Scooter scooter = db.getScooter(scooterid);
		scooter.setStatus(userid);
		db.setScooter(scooter);

		// order
		Order order = new Order(userid, scooterid, initstationID, inittime);
		db.setOrder(order);

		// user
		User user = db.getUser(userid);
		user.setStatus(scooterid); // -1-blocked,0-idle，other number represents scooter id.
		db.setUser(user);
	}
}
