import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogBox extends JFrame {

  public DialogBox() throws HeadlessException {
    setSize(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button1 = new JButton("Message dialog");
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog((Component) e.getSource(), "Thank you!");
      }
    });

    JButton button2 = new JButton("Input dialog");
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        String text = JOptionPane.showInputDialog((Component) e.getSource(), "What is your name?");

        if (text != null && !text.equals("")) {
          JOptionPane.showMessageDialog((Component) e.getSource(), "Hello " + text);
        }
      }
    });

    JButton button3 = new JButton("Yes no dialog");
    button3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog((Component) e.getSource(),
            "Close this application?");
        if (result == JOptionPane.YES_OPTION) {
          System.exit(0);
        } else if (result == JOptionPane.NO_OPTION) {
          System.out.println("Do nothing");
        }
      }
    });

    setLayout(new FlowLayout(FlowLayout.CENTER));
    getContentPane().add(button1);
    getContentPane().add(button2);
    getContentPane().add(button3);
  }

  public static void main(String[] args) {
    new DialogBox().setVisible(true);
  }
}