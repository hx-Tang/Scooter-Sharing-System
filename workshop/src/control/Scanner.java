package control;

import db.DB;
import db.DBImpl;
import storage.Order;
/**
 * this class provides the function of scanner.
 */
public class Scanner {

	// sacnner
	public static int[] scanner(int stationid) {
		// open db
		DB db = new DBImpl();
		// init. return array
		int[] re = new int[] { 0, 0, 0, 0, stationid };// return value:user id,scooter id,slot id,station id.
		// scan
		int userid = Util.Scan();
		// user cancel
		if (userid == -1) {
			// Util.display("bye");
			re[0] = -4;
			return re;
		}
		// not registered
		if (!db.hasUser(userid)) {
			Util.display("please register first");
			re[0] = -3;
			return re;
		}
		// blocked
		if (PayFine.isblocked(userid)) {//re-used
			Util.display("please pay fine first");
			re[0] = -5;
			return re;
		}
		// write userid
		re[1] = userid;
		// read order
		if (inOrder(userid)) {
			// return
			re[0] = 1;
			// read slot
			int slotid = DropOff.isFull(db.getStation(stationid));//re-used
			// station full
			if (slotid == -1) {
				Util.display("Station full");
				re[0] = -2;
				return re;
			}
			// scooterid
			re[2] = db.getUser(userid).getStatus();
			// slotid
			re[3] = slotid;
		} else {
			// pickup
			re[0] = 2;
			// read slot
			int slotid = PickUp.isEmpty(db.getStation(stationid));//re-used
			// station empty
			if (slotid == -1) {
				Util.display("Station empty");
				re[0] = -1;
				return re;
			}
			// slot id
			re[3] = slotid;
		}
		// return
		return re;
	}

	// inOrder
	public static boolean inOrder(int userid) { // in order: true

		DBImpl db = new DBImpl();
		Order orderlast = db.getOrderbyUser(userid);
		if (orderlast == null)
			return false;
		if (orderlast.getEndtime().equals(""))
			return true;
		return false;
	}
}
