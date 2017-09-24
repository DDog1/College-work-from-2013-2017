import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Lab8_1 extends JFrame implements ActionListener{
JButton openButt, saveButt;
JFileChooser fc;
JTextArea log;
static final String newline = "\n";

	public Lab8_1()
	{
		super("lab8");
		setSize(200,200);
		setVisible(true);

		openButt = new JButton("open");
		openButt.addActionListener(this);

		add(openButt);
	}

	public void actionPerformed(ActionEvent e)
	{
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fc.showOpenDialog (this);
	}

    public static void main(String[] args) {

                Lab8_1 frame = new Lab8_1();
            }


}