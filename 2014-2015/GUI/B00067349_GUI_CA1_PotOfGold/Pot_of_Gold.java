/********************************************************************/
/*	Name : Darren Cosgrave											*/
/*	Date : 6 / November / 2014										*/
/*	Program name : Pot_of_Gold										*/
/*	Task : CA going for 15%											*/
/*	Description : A GUI game where you have to find the pot of gold	*/
/*	before you run out of lives. You lose a life if a leprechaun	*/
/*	pops up and gain a live if a raindow pops up.					*/
/********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

class Pot_of_Gold extends JFrame implements ActionListener
{
	static int lives = 2;//number of lives at the start of the game
	static int rainbow = 0;//number of found rainbows
	static int leprechaun = 0;//number of found leprechauns
	static int Won=0;//Will make the program end when it = 1

	static int pot_amount=0;
	static int rainbow_amount=0;
	static int leprechaun_amount=0;

	static JLabel label = new JLabel();

//******************************************************************//

	//Makes the images
	static ImageIcon pic_1 = new ImageIcon("pot-of-gold.jpg");
	static ImageIcon pic_2 = new ImageIcon("Rainbow.jpg");
	static ImageIcon pic_3 = new ImageIcon("leprechaun.jpg");

//******************************************************************//

	//Makes the buttons
	static JButton Button_1 = new JButton("See");
	static JButton Button_2 = new JButton("if");
	static JButton Button_3 = new JButton("you");
	static JButton Button_4 = new JButton("can");
	static JButton Button_5 = new JButton("find");
	static JButton Button_6 = new JButton("the");
	static JButton Button_7 = new JButton("pot");
	static JButton Button_8 = new JButton("of");
	static JButton Button_9 = new JButton("gold");

//******************************************************************//

	//Items in the game
	static JLabel Lives = new JLabel("Lives = "+lives);
	static JLabel Rainbow = new JLabel("Rainbows found = "+rainbow);
	static JLabel Leprechaun = new JLabel("Leprechauns found = "+leprechaun);

//******************************************************************//

	public Pot_of_Gold()
	{
		super("Pot of Gold");//Sets the title of the JFrame
		setVisible(true);//Lets you see the program
		setSize(500,500);//sets the size of the JFrame
		setLocation(400,100);//sets the location of the JFrame
		setResizable(true);//sets the resize to on or off for the JFrame
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container c = getContentPane();

//******************************************************************//

		//Makes the JPanel
		JPanel p = new JPanel();

		//Makes the rows 5 and cols 3 and sets the space to 5 all around the buttons
		p.setLayout(new GridLayout(5,3,5,5));

		//Sets the space around the JPanel to 5 all round
		p.setBorder(BorderFactory.createEmptyBorder(
										5, //top
										5, //left
										5, //bottom
										5) //right
										);

//******************************************************************//

		//Adds the buttons to the panel and the Container at the end.
		//Also adds it to the ActionListener
		p.add(Button_1);
		Button_1.addActionListener(this);

		p.add(Button_2);
		Button_2.addActionListener(this);

		p.add(Button_3);
		Button_3.addActionListener(this);

		p.add(Button_4);
		Button_4.addActionListener(this);

		p.add(Button_5);
		Button_5.addActionListener(this);

		p.add(Button_6);
		Button_6.addActionListener(this);

		p.add(Button_7);
		Button_7.addActionListener(this);

		p.add(Button_8);
		Button_8.addActionListener(this);

		p.add(Button_9);
		Button_9.addActionListener(this);

//******************************************************************//

		//Adds lives,rainbow, leprechaun and the reset button to the panel
		p.add(Lives);

		p.add(Rainbow);

		p.add(Leprechaun);

		JButton Reset = new JButton("Reset");
		p.add(Reset);
		Reset.addActionListener(this);

//******************************************************************//

		//Add the label to panel and the panel to the container
		p.add(label);
		c.add(p);
	}

	public static void main(String[]args)
	{
		Pot_of_Gold game = new Pot_of_Gold();

		//Exits the JFrame when the close button on the top right is clicked
		game.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("See"))
		{
			random(Button_1);
		}

		else if (e.getActionCommand().equals("if"))
		{
			random(Button_2);
		}

		else if (e.getActionCommand().equals("you"))
		{
			random(Button_3);
		}

		else if (e.getActionCommand().equals("can"))
		{
			random(Button_4);
		}

		else if (e.getActionCommand().equals("find"))
		{
			random(Button_5);
		}

		else if (e.getActionCommand().equals("the"))
		{
			random(Button_6);
		}

		else if (e.getActionCommand().equals("pot"))
		{
			random(Button_7);
		}

		else if (e.getActionCommand().equals("of"))
		{
			random(Button_8);
		}

		else if (e.getActionCommand().equals("gold"))
		{
			random(Button_9);
		}

//***************************************************************************//

		//Resetting the frame to the original state before user touched it
		else if (e.getActionCommand().equals("Reset"))
		{
			label.setText("Reset");
			dispose();

			Button_1.setText("See");
			Button_1.setIcon(null);

			Button_2.setText("if");
			Button_2.setIcon(null);

			Button_3.setText("you");
			Button_3.setIcon(null);

			Button_4.setText("can");
			Button_4.setIcon(null);

			Button_5.setText("find");
			Button_5.setIcon(null);

			Button_6.setText("the");
			Button_6.setIcon(null);

			Button_7.setText("pot");
			Button_7.setIcon(null);

			Button_8.setText("of");
			Button_8.setIcon(null);

			Button_9.setText("gold");
			Button_9.setIcon(null);

//***************************************************************************//

			lives=2;
			Lives.setText("Lives = "+lives);

			rainbow=0;
			Rainbow.setText("Rainbows found = "+rainbow);

			leprechaun=0;
			Leprechaun.setText("Leprechauns found = "+leprechaun);

//***************************************************************************//

			Pot_of_Gold game = new Pot_of_Gold();
		}

//***************************************************************************//

		if(lives==0)
		{
			System.out.println("You have lost the game good bye!!");
			JOptionPane.showMessageDialog(null,"You have lost. Good bye!!","A plain message",JOptionPane.PLAIN_MESSAGE);
			dispose();
		}

		if(Won==1)
		{
			System.out.println("You have won the game good bye!!");
			JOptionPane.showMessageDialog(null,"You have won. Good bye!!","A plain message",JOptionPane.PLAIN_MESSAGE);
			dispose();
		}

//**************************************************************************//

		else if(e.getActionCommand().equals(""))
		{
			label.setText("Sorry you cant pick this!!");
		}
	}

	static void random(JButton t)
	{
		Random rand = new Random();
		int ran = rand.nextInt(5);
		ran++;

		if(ran==1 && pot_amount==0)//pot
		{
			label.setText("You won!!!");
			t.setText("");
			pot_amount++;
			Won++;

			t.setIcon(pic_1);
		}

		else if(ran==2 && rainbow_amount<=2)//Rainbow
		{
			label.setText("You gained a life");
			t.setText("");
			rainbow++;
			lives++;
			Lives.setText("Lives = "+lives);
			rainbow_amount++;
			Rainbow.setText("Rainbows found = "+rainbow);

			t.setIcon(pic_2);
		}

		else if(ran==3 && leprechaun_amount<=2)//Leprechaun
		{
			label.setText("You loss a life");
			t.setText("");
			leprechaun++;
			lives--;
			Lives.setText("Lives = "+lives);
			leprechaun_amount++;
			Leprechaun.setText("Leprechauns found = "+leprechaun);

			t.setIcon(pic_3);
		}

		if(ran==4)//Blank
		{
			t.setText("");
			label.setText("Blank");
		}

		else
		{
			ran = rand.nextInt(5);
		}
	}
}