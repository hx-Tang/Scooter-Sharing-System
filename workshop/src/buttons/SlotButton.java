package buttons;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import control.*;
import storage.Slot;

public class SlotButton extends JButton{
	
	public boolean flag = false;//slot lock.
	private Shinning a;//thread of shining and timing.
	public int[] returnValue = new int[5];//return value of scanner.
	
	public SlotButton(String name) {
		super(name);
		this.setBackground(new Color(255, 192, 203));
		this.setFont(new Font("Calibri", Font.PLAIN, 12));
		SlotButton btn = this;
		//click response.
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag) {
					//click yes to stop shining.
					a.stopShinning();
					if(returnValue[0]==2) {
						//Util.display("pickup scooter No."+ returnValue[2] +" at slot No."+ returnValue[3]);
						PickUp.pickUp(returnValue[1], returnValue[3], returnValue[2], returnValue[4]);
						//pink represents available.
						btn.setBackground(new Color(255, 192, 203));
						btn.setText("");
					}
					else if(returnValue[0]==1) {
						Util.display("return scooter No."+ returnValue[2] +" at slot No."+ returnValue[3]);
						DropOff.dropOff(returnValue[1], returnValue[3], returnValue[2], returnValue[4]);
						//blue represents occupy.
						btn.setBackground(new Color(104, 211, 251));
						btn.setText(""+returnValue[2]);
					}					
					//lock slot.
					flag = false;
				}
			}
		});
	}
	
	//activate slot.
	public void buttonShinning() {
		flag = true;
		a = new Shinning(this);
		a.start();
		System.out.print(a.isAlive());
	}
	
	public void setContent(Slot slot) {
		int status = slot.getStatus();
		if(status==0) {//pink represents available.
			this.setBackground(new Color(255, 192, 203));
			this.setText("");
		}else {//blue represents occupy.
			this.setBackground(new Color(104, 211, 251));
			this.setText(""+status);
		}
	}
}

