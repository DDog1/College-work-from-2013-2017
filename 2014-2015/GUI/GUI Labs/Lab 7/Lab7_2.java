
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Lab7_2 extends JFrame {
    JDesktopPane desktop;

    public Lab7_2 () {
    desktop = new JDesktopPane();

    JInternalFrame innerframe = new JInternalFrame("Internal Window" ,
													false, //resizable
													true, //closable
													true, //maximizable
													true);//iconifiable
	innerframe.setSize(640,480);
	innerframe.setVisible(true);
	innerframe.setLocation(10,10);
	innerframe.setMenuBar(createMenuBar());
	setContentPane(desktop);
	setVisible(true);
	setSize(800, 600);
	desktop.add(innerframe);
    }
	 protected JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();
//menubar
	        JMenu menu = new JMenu("File");
	        menuBar.add(menu);
//menuItems
	        JMenuItem menuItem = new JMenuItem("New");
	        menu.add(menuItem);

	        menuItem = new JMenuItem("Save");
	        menu.add(menuItem);

	        menuItem = new JMenuItem("Close");
	        menu.add(menuItem);

	        return menuBar;
    }

      public static void main(String[] args) {
           Lab7_2 frame = new Lab7_2();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setJMenuBar(createMenuBar());

           //Display the window.
           frame.setVisible(true);
           frame.setTitle("Frame");
    }
}