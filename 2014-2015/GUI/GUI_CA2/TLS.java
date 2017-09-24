import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

public class TLS extends JInternalFrame implements MouseListener
{


		JComboBox<String> Languages = new JComboBox<>();
	    JComboBox combo;

String loadedPicture = null;

	ImageIcon square = new ImageIcon(this.getClass().getResource("/index.jpg"), "Square");
		ImageIcon circle = new ImageIcon(this.getClass().getResource("/index.png"), "Circle");
		ImageIcon triangle = new ImageIcon(this.getClass().getResource("/index1.png"), "Triangle");

	ImageIcon [] images = {square, circle, triangle};

	JLabel answer1 = new JLabel(" ");
	JLabel answer2 = new JLabel(" ");
	JLabel answer3 = new JLabel(" ");

		JPanel panel = new JPanel();

		JPanel panel2 = new JPanel(new GridLayout(1,3));

		JLabel label = new JLabel(" ");

		JLabel label2 = new JLabel(" ");

		JLabel label3 = new JLabel(" ");


			String [] japaneseSquare = {"Hiroba***", "Carret", "Risu"};
			String [] englishSquare = {"Square", "Squire", "Sasquatch"};
			String [] spanishSquare = {"Manzana", "Cuadrado***", "Speedy Gonzales"};

			String [] japaneseCircle = {"Kirito", "Akatsuki", "Sakuru***"};
			String [] englishCircle = {"Carl", "Circle", "Circus"};
			String [] spanishCircle = {"Chirizo", "Círculo***", "Chica"};

			String [] japaneseTriangle = {"Sankakkei***", "Sakura", "Boenkyo"};
			String [] englishTriangle = {"Triangel", "Triangle", "Squirrel"};
			String [] spanishTriangle = {"Triángulo", "Ding Dongio", "Tratando"};

    public TLS()
    {

    	super("Shape Game");
    	Container c = getContentPane();



panel.addMouseListener(this);


		Languages.addItem("English");
		Languages.addItem("Japanese");
		Languages.addItem("Spanish");


		panel2.add(Languages);
		this.add(panel2, BorderLayout.SOUTH);
		Languages.addActionListener(
			                new ActionListener(){
			                    public void actionPerformed(ActionEvent e){
			                        combo = (JComboBox)e.getSource();
	                        String Language = (String)combo.getSelectedItem();


	                        loadLabels(Language);
						}});


		this.answer1.addMouseListener(this);
		this.answer2.addMouseListener(this);
		this.answer3.addMouseListener(this);

		c.add(panel);
		panel.add(label);
		panel2.add(answer1);
		panel2.add(answer2);
		panel2.add(answer3);
		validate();
		setClosable(true);
		setMaximizable(true);
		setSize(390,240);
		setVisible(true);
		setLocation(205,205);
		loadPicture();


	}//close constructor

	public String loadPicture() {
			Random rand = new Random();
			int rnum = rand.nextInt(3) + 0;
			label.setIcon(images[rnum]);
			return images[rnum].getDescription();

	}

private void loadLabels(String language){
	//************************************************************English
		if(language.equals("English"))
        {
        	if (loadedPicture.equals("Square"))
        	{

        		answer1.setText(englishSquare[0]);
				answer2.setText(englishSquare[1]);
				answer3.setText(englishSquare[2]);

        	}
			else if(loadedPicture.equals("Circle")){
				answer1.setText(englishCircle[0]);
				answer2.setText(englishCircle[1]);
				answer3.setText(englishCircle[2]);

			}

			else if(loadedPicture.equals("Triangle")){
				answer1.setText(englishTriangle[0]);
				answer2.setText(englishTriangle[1]);
				answer3.setText(englishTriangle[2]);
			}
		}
		//*****************************************************Japanese
		else if (language.equals("Japanese")){
			if (loadedPicture.equals("Square"))
        	{

				answer1.setText(japaneseSquare[0]);
				answer2.setText(japaneseSquare[1]);
				answer3.setText(japaneseSquare[2]);;

        	}
			else if(loadedPicture.equals("Circle"))
			{
				answer1.setText(japaneseCircle[0]);
				answer2.setText(japaneseCircle[1]);
				answer3.setText(japaneseCircle[2]);
			}

			else if(loadedPicture.equals("Triangle"))
			{
				answer1.setText(japaneseTriangle[0]);
				answer2.setText(japaneseTriangle[1]);
				answer3.setText(japaneseTriangle[2]);
			}
		}
		//**********************************************************Spanish
		else if (language.equals("Spanish"))
		{
			if (loadedPicture.equals("Square"))
        	{

				answer1.setText(spanishSquare[0]);
				answer2.setText(spanishSquare[1]);
				answer3.setText(spanishSquare[2]);;

        	}
			else if(loadedPicture.equals("Circle"))
			{
				answer1.setText(spanishCircle[0]);
				answer2.setText(spanishCircle[1]);
				answer3.setText(spanishCircle[2]);

			}

			else if(loadedPicture.equals("Triangle"))
			{
				answer1.setText(spanishTriangle[0]);
				answer2.setText(spanishTriangle[1]);
				answer3.setText(spanishTriangle[2]);
			}
		}
	}




		public void actionPerformed(ActionEvent arg0)
		{

		}

	    public void mouseEntered(MouseEvent e)
	    {

	    }

	    public void mouseExited(MouseEvent e)
	    {

    	}

		public void mousePressed(MouseEvent e)
		{

    	}

    	public void mouseReleased(MouseEvent e)
    	{

    	}

    	public void mouseClicked(MouseEvent e)
    	{
    	  if(e.getSource() instanceof JLabel)
    	  {
			((JLabel)e.getSource()).setText(" ");
	      }
    	}
}