import java.util.*;
public class choiceFactory {
    multiChoice ui;
    //This class returns a Panel containing
    //a set of choices displayed by one of
    //several UI methods. 
    public multiChoice getChoiceUI(Vector choices) {
        if (choices.size() <=3)
            //return a panel of checkboxes
            ui = new checkBoxChoice(choices);
        
        //if the japanese stocks greater than eqaul to 5
        else if (choices.size() >= 5)
        	//return the radioButtonchioce
        	ui = new radioButtonChoice(choices);
        else
            //return a multi-select listbox panel
            ui = new listboxChoice(choices);
        return ui;
    }            
}

