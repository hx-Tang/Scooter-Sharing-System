package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Util {

	// time difference ,unit:minute
	public static int timeSlot(String start, String end) {

		Date starttime = toTime(start);
		Date endtime = toTime(end);
		Long timeslot = endtime.getTime() - starttime.getTime();//time difference:minute
		Integer ss = 1000;
		Integer mi = ss * 60;
		Long minute = timeslot / mi;
		return minute.intValue();
	}

	// string convert to time.
	public static Date toTime(String time) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd'/'HH:mm");
		Date datetime = null;
		try {
			datetime = ft.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}

	// get current time.
	public static String getTime() {
		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd'/'HH:mm");
		return ft.format(now);
	}

	// simulate scan card.
	public static int Scan() {
		while (true) {
			String id = JOptionPane.showInputDialog(null, "Please enter your ID：\n", "Scanner", JOptionPane.PLAIN_MESSAGE);
			if (id == null) {
				return -1;
			} else if (verifyid(id)) {
				return Integer.parseInt(id);
			}
			JOptionPane.showMessageDialog(null, "Please enter the correct ID", "Scanner", JOptionPane.WARNING_MESSAGE);
		}
	}

	// verify user id.
	private static boolean verifyid(String input) {
		try {
			int i = Integer.parseInt(input);
			if (String.valueOf(i).length() == 9)
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	// message window.
	public static void display(String input) {
		JOptionPane.showMessageDialog(null, input, "Message", JOptionPane.PLAIN_MESSAGE);
	}

	// convert station name.
	public static char parseStation(int stationid) {
		switch (stationid) {
		case 1:
			return 'A';
		case 2:
			return 'B';
		case 3:
			return 'C';
		default:
			return 'X';
		}
	}
}
