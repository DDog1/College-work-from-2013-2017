import java.awt.Panel;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class EarthMaker extends JFrame implements ActionListener
{
		JButton makeEarthButton;
		JList list;
		JScrollPane scroll;
		// private EarthThingsAbstractFactory earthThingsAbstractFactory = null;

	public EarthMaker()
	{
		super("EARTH MAKER");
		Gui();
	}

	public void Gui()
	{
		Vector<Thing> things = new Vector<Thing>(1000000);

		makeEarthButton = new JButton("MAKE EARTH");
		list = new JList(things);

		scroll = new JScrollPane(list);

		Panel left = new Panel();
        add(left);

        makeEarthButton.addActionListener(this);

        left.add(makeEarthButton);
		left.add(scroll);
		setSize(700,500);
		setVisible(true);
	}


	public static void main(String[] args)
	{
		new EarthMaker();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==makeEarthButton)
		{
			//EarthThingsAbstractFactory earthThingsAbstractFactory = new Dog("fyughi","ghj");
			System.out.println("Pressed");

			//if(earthThingsAbstractFactory!=null)
			//{
				//System.out.println("Created");
			//}
		}
	}

}
