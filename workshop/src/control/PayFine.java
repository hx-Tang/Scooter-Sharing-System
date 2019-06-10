package control;

import javax.swing.JOptionPane;

import db.DBImpl;
import storage.User;

public class PayFine {
	/**
	 * related to user account.
	 */
	// whether user account is blocked.
	public static boolean isblocked(int userid) {
		DBImpl DB = new DBImpl();
		User user = DB.getUser(userid);
		if (user.getStatus() != -1) {
			return false;
		} // false-user account is not blocked.
		else
			return true;
	}

	// whether user need to pay fine.
	public static boolean verifyFine(int userid) {
		DBImpl DB = new DBImpl();
		if (DB.hasUser(userid)) {
			if (isblocked(userid)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "You don't need to pay fine.", "Not required",
						JOptionPane.PLAIN_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "The user doesn't exist.", "User doesn't exist",
					JOptionPane.PLAIN_MESSAGE);
			return false;
		}
	}

	// user pay fine successfully.
	public static void payfine(int userid) {
		DBImpl DB = new DBImpl();
		User user = DB.getUser(userid);
		user.setStatus(0);
		DB.setUser(user);
	}
}
