package buttons;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import storage.Scooter;
 
/**there are two things to do when making a circular button:the first thing is to override a method to draw
 * a circle.the second thing is to set some events so that only if you click the right range of button,the system
 * will give you response.
 *
 */
public class ScooterButton extends JButton {
 
    public ScooterButton(String label) {
        super(label);
       
 
        // get the perfect size of button.
        Dimension size = getPreferredSize();
//        size.width = size.height = Math.max(size.width, size.height);
        size.width = size.height =20;
        setPreferredSize(size);
       
        setContentAreaFilled(false);
        this.setBorderPainted(false); // do not draw border.
        this.setFocusPainted(false); //do not draw focused state.
        this.setBackground(new Color(255, 192, 203));
        this.setFont(new Font("Century", Font.PLAIN, 10));
    }
 
    //draw the label and background of circular buttons. 
    protected void paintComponent(Graphics g) {
 
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray); // highlighting when click it.
        } else {
            g.setColor(getBackground());
        }
        // fillOval-draw a intangent ellipse of a rectangle and fill in the ellipse.
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
        super.paintComponent(g);
    }
 
    // draw the border of button using simple arc.
    protected void paintBorder(Graphics g) {
        g.setColor(Color.white);
        // drawOval-draw a intangent ellipse of a rectangle,but not fill in it,only draw border. 
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
 
    // shape object save the shape of button,which is beneficial to listen events being clicked.
    Shape shape;
 
    public boolean contains(int x, int y) {
 
        if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
            // construct a ellipse object.
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        // Determine whether the mouse's x and y coordinates fall within the button shape.
        return shape.contains(x, y);
    }
 
	//set content.
	public void setContent(Scooter scooter, JLabel label) {
		int status = scooter.getStatus();
		if(status==0) {//pink represents available.
			this.setBackground(new Color(255, 192, 203));
			//text represents available.
			label.setText("available");
		}else {//blue represents occupy.
			this.setBackground(new Color(104, 211, 251));
			//change to user name.
			label.setText(""+status);
		}
	}
}