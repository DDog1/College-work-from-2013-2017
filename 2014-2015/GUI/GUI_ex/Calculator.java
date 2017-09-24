import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
    //Declaration of all calculator's components.
    JPanel windowContent;
    JTextField displayField;
    JButton buttons[];
    JPanel pl;

    //Constructor creates the components in memory and adds the to the frame using combination of Borderlayout.
    Calculator() {
        windowContent = new JPanel();
        buttons = new JButton[9];

    // Set the layout manager for this panel
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

    //Create button field and place it in the North area of the window
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }

    //Create the panel with the GridLayout that will contain 12 buttons - 10 numeric ones, and button with the points
    //and the equal sign.
        pl = new JPanel ();
        GridLayout gl = new GridLayout(4,3);
        pl.setLayout(gl);

    //Add window controls to the panel pl.
        for(int i = 0; i < 9; i++) {
            pl.add(buttons[i]);
        }

    //Add the panel pl to the center area of the window
        windowContent.add(pl);
    //Create the frame and set its content pane
        JFrame frame = new JFrame("Pot for Gold");
        frame.setContentPane(windowContent);
    //set the size of the window to be big enough to accomodate all controls.
        frame.pack();

    //set Size of display window
    	frame.setSize(400, 500);
    //Finnaly, display the window
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}