
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Lab7_1b extends JFrame {
    JDesktopPane desktop;

    public Lab7_1b () {
    desktop = new JDesktopPane();
    JInternalFrame innerframe = new JInternalFrame("Internal Window" ,
													false, //resizable
													true, //closable
													true, //maximizable
													true);//iconifiable
	innerframe.setSize(640,480);
	innerframe.setVisible(true);
	innerframe.setLocation(10,10);
	setContentPane(desktop);
	setVisible(true);
	setSize(800, 600);
	desktop.add(innerframe);
    }

       private static void createAndShowGUI() {
           //Make sure we have nice window decorations.
           //JFrame.setDefaultLookAndFeelDecorated(true);

           //Create and set up the window.
           Lab7_1b frame = new Lab7_1b();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setTitle("Frame");
           //Display the window.
           frame.setVisible(true);
    }

       public static void main(String[] args) {
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run()
             {
                 createAndShowGUI();
             }
        	}
        );
	   }
 }