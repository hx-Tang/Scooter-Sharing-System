package control;

import javax.swing.JOptionPane;

import db.DBImpl;
import storage.User;
/**
 *this class provides the function of registering .
 */
public class Register {
	// register
	public static void register(int i, String t2, String t3) //write to database after pressing 'register' button.
	{
		DBImpl DB = new DBImpl();
		if (DB.hasUser(i)) {
			JOptionPane.showMessageDialog(null, "This ID has been registered.", "Registration Error",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Your registration is successful", "Successful Registration",
					JOptionPane.PLAIN_MESSAGE);
			User user = new User(i, t2, t3);
			DB.setUser(user);
		}
	}

	// verifyInfo
	public static boolean verifyInfo(String t1, String t2, String t3) {
		try {
			int i = Integer.parseInt(t1);
		} catch (NumberFormatException exception) {
			return false;
		}

		if (t2.matches("[a-zA-Z]+") == true || t2.matches("[\\u4e00-\\u9fa5]+") == true || t2.contains(" ") == true) {
			if (t1.length() == 9) {
				if (t3.contains("@") && t3.contains(".")) {
					if (t3.lastIndexOf(".") > t3.lastIndexOf("@")) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
