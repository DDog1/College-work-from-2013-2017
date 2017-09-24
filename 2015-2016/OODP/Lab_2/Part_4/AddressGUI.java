import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddressGUI extends JFrame implements ActionListener
{

Container con = this.getContentPane();
JPanel main = new JPanel(new GridLayout(3, 2));
JPanel pane = new JPanel();

	AddressGUI()
	{
		super("Address Frame.");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] addressTypes = {"Select...", "Ireland", "America"};
		JComboBox<String> addressList = new JComboBox<String>(addressTypes);
		addressList.addActionListener(this);
		pane.add(addressList);
		main.add(pane);
		con.add(main);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[])
	{
		new AddressGUI();
	}

	public void actionPerformed(ActionEvent e)
	{
		JComboBox cb = (JComboBox)e.getSource();
		String selected = (String)cb.getSelectedItem();
		AddressFactory aF = new AddressFactory();

		if(selected.equals("Ireland"))
		{
			IrelandAddress sA = aF.getIrelandAddress();
			JPanel nJP = sA.getJPanel();
			main.removeAll();
			main.updateUI();
			main.add(pane);
			main.add(nJP);
			revalidate();
		}
		else if(selected.equals("America"))
		{
			USAAddress sA = aF.getUSAAddress();
			JPanel nJP = sA.getJPanel();
			main.removeAll();
			main.updateUI();
			main.add(pane);
			main.add(nJP);
			revalidate();
		}
		else
		{

		}
	}
}