import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class BlueDecorator extends JFrame implements ColorDecorator, MouseListener{

	private ColorDecorator colorDec;
	private BlueDecorator blueDec;

	//
	private JComboBox chooseColor;
	private Container c;
	private JPanel p;
	private JLabel colorMe;
	private static String [] s;

	public BlueDecorator(){
		super("Blue Colour");
		setGUIBlue();
	}

	public void setGUIBlue(){
		c = getContentPane();

		p = new JPanel();

		//label set to the
		colorMe = new JLabel("      ", JLabel.CENTER);

		//border set to the black
		Border borderColor = BorderFactory.createLineBorder(java.awt.Color.BLACK, 200);

		colorMe.setBorder(borderColor);

		p.add(colorMe);

		s = new String[3];

		s[0] = "";
		s[1] = "Blue";
		s[2] = "Red";

		//creating the comobo box
		chooseColor = new JComboBox();


		//addting item blue and red
		chooseColor.addItem(s[0]);
		chooseColor.addItem(s[1]);
		chooseColor.addItem(s[2]);

		chooseColor.addMouseListener(this);

		//adding to the panel
		p.add(chooseColor);

		//adding it to the frame
		c.add(p);

		setSize(500, 500);
		setVisible(true);

	}

	public ColorDecorator getColor(){
		return blueDec;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(s[1] == "Blue"){
			//border set to the black
			Border borderColor = BorderFactory.createLineBorder(java.awt.Color.BLUE, 200);

			colorMe.setBorder(borderColor);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



}
