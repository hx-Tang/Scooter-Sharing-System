package buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import control.*;

public class ScanButton extends JButton{
	ArrayList<SlotButton> btnList=new ArrayList<SlotButton>();//the list of slot button objects.
	//constrctor:name,station id,the list of slot buttons.
	public ScanButton(String name,int id,ArrayList<SlotButton> btnList) {
		super(name);
		this.btnList=btnList;
		this.setBackground(new Color(255, 192, 203));
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		//response
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//the logic of scanner.
				int[] returnValue = Scanner.scanner(id);
				//the process of scanner.
				if (returnValue[0]<0) return;//quit due to the exception.
				SlotButton button=btnList.get(returnValue[3]-1);//read slot ,minus 1
				//pass it to slot.
				button.returnValue = returnValue;
				button.buttonShinning();
			}
		});
	}
}
