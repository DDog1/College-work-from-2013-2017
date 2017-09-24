import java.awt.*;
import java.util.*;
import javax.swing.*;

public class radioButtonChoice extends multiChoice {
	 //This derived class creates 
    //vertical grid of checkboxes
    int count;           //number of checkboxes
    JPanel p;             //contained in here
//--------------------------------------------
    //contructor for the radio button choice
    public radioButtonChoice(Vector choices){
    	super(choices);
        count = 0;
        p = new JPanel();
    }
    
  
	@Override
	public JPanel getUI() {
		String s;

        //create a grid layout 1 column by n rows
        p.setLayout(new GridLayout(choices.size(), 1));  
        //and add labeled check boxes to it
        for (int i=0; i< choices.size(); i++) {
            s =(String)choices.elementAt(i);
            p.add(new JRadioButton(s));
            count++;
        }
        return p;
	}

	@Override
	public String[] getSelected() {
		JRadioButton rb;
        Vector rlist = new Vector();
        
        //Copy checkboxes what are checked
        //into the Vector clist
        
        for (int i = 0; i < count; i++ ) {
            rb = (JRadioButton)p.getComponent(i);
            if (rb.isSelected ())
                rlist.addElement(rb.getText());
        }
        //create a string array the size of the
        //number of checked boxes
        String[] slist = new String[rlist.size()];

        //copy labels of chekced boxes into
        //the string array
        for (int i = 0; i < rlist.size(); i++)
            slist[i] = (String)(rlist.elementAt(i));
        return(slist);
	}

	@Override
	public void clearAll() {
		//uncheck all boxes
        for (int i=0; i < count; i++) {
            ((JRadioButton)(p.getComponent(i))).setSize(300, 300);
        }
	}

}
