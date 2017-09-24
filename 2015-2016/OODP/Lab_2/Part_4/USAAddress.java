import java.awt.*;
import javax.swing.*;

public class USAAddress extends Address {

JPanel pane = new JPanel(new GridLayout(5,2));

	USAAddress() {
		JLabel add1 = new JLabel("Address line 1");
		JTextField field1 = new JTextField(10);
		JLabel add2 = new JLabel("Address line 2");
		JTextField field2 = new JTextField(10);
		JLabel add3 = new JLabel("State");
		JTextField field3 = new JTextField(10);
		JLabel add4 = new JLabel("ZIP code");
		JTextField field4 = new JTextField(10);
		JButton reset = new JButton("Reset");
		JButton submit = new JButton("Submit");

		pane.add(add1);
		pane.add(field1);
		pane.add(add2);
		pane.add(field2);
		pane.add(add3);
		pane.add(field3);
		pane.add(add4);
		pane.add(field4);
		pane.add(reset);
		pane.add(submit);
	}

	public JPanel getJPanel()
	{
		return pane;
	}
}