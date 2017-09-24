import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Lab8_2 extends JPanel implements MouseInputListener {

JLabel mousey;

	public Lab8_2()
	{
		super(new BorderLayout());

		mousey = new JLabel("hello", 0);
		add(mousey);
		mousey.addMouseListener(this);
	}

	/************************ LISTENERS *********************************/
		public void mouseClicked(MouseEvent e)
		{
			mousey.setText("Mouse Clicked");
		}

		public void mouseEntered(MouseEvent e)
		{
			mousey.setText("Mouse Entered");
		}

		public void mouseExited(MouseEvent e)
		{
			mousey.setText("mouse Exited");
		}

		public void mousePressed(MouseEvent e)
		{
			mousey.setText("mouse Pressed");
		}

		public void mouseReleased(MouseEvent e)
		{
			mousey.setText("mouse Released");
		}

		public void mouseDragged(MouseEvent e)
		{
			mousey.setText("mouse Dragged");
		}

		public void mouseMoved(MouseEvent e)
		{
			mousey.setText("mouse Moved");
		}

	/***********************Make GUI and RUN**********************************************/
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Lab8_2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new Lab8_2();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

}
}