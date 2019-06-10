package buttons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Util;

public class Shinning extends Thread{
	private SlotButton btn;
	public static boolean exit=false;
	long start, end;
	public Shinning(SlotButton btn) {
		this.btn = btn;
	}
	
	@Override
	public void run() {
		exit = false;
		start = System.currentTimeMillis();
		Color initColor = btn.getBackground();
		while (!exit) {
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			Color randomColor = new Color(red, green, blue);
			btn.setBackground(randomColor);
			try {
				Shinning.sleep(500);
			} catch (Exception e) {
				break;
			}
			end = System.currentTimeMillis();
			// Lock parking space for more than 60 seconds
			if ((end - start) > 5 * 1000) {
				Util.display("Timeout!");
				btn.flag = false;
				exit = true;
				btn.setBackground(initColor);
				break;
			}
		}
	}
	
	//stop threads
	public void stopShinning() {
		exit = true;
		btn.setBackground(new Color(255, 192, 203));
	}
}
