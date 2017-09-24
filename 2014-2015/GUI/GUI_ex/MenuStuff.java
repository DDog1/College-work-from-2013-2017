import javax.swing.*;
import java.awt.*;

class MenuStuff extends JFrame
{
	public MenuStuff()
	{
		JMenuBar viewMenuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenu openMenu = new JMenu("Open");

		viewMenuBar.add(fileMenu);
		viewMenuBar.add(openMenu);

		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);

		setJMenuBar(viewMenuBar);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[]args)
	{
		MenuStuff type1 = new MenuStuff();
	}
}