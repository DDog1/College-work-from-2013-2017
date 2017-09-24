
import javax.swing.*;

public class InternalFrame3 extends JFrame
{

	public InternalFrame3()
	{
		super("Multiframe");
		int x=20, y=40;                                //postion of first Internal frame

		JDesktopPane OuterPane = new JDesktopPane();   //Create the desktop to add the frames

        for(int i = 0; i < 5; i++)
        {
			OuterPane.add(getFrame(200,200,x=x+60,y=y+40));   // call method to create a frame 5 add 20 to x,y postion each time
		}

         setJMenuBar(createMenuBar( ));                 //set  jmenuBar and call method for a menubar
		 setContentPane(OuterPane);                     //set  the content pane (outerpane)
         setSize(600,600);
		 setVisible(true);                              // set visible (default invisible)
}  //end of constructor

 /****************************Main Method**********************************************/
        public static void main(String []args)
	    {
          InternalFrame3 frame = new InternalFrame3();    //create an instance of the class internal frame and run
        }  // end main

 /********************************Create Frame Method **********************************************/

       	public JInternalFrame getFrame(int width, int height, int xLoc, int yLoc) //method to create internal frames
       	{                                                                         //parameters width,height, x and y location
            JInternalFrame multiFrame = new JInternalFrame("MultiFrame");         //crate the frame

	   		multiFrame.setIconifiable(true);                                      //set multiframe attributes
	   		multiFrame.setResizable(false);
	   		multiFrame.setMaximizable(true);
	   		multiFrame.setClosable(true);
            multiFrame.setLocation(xLoc,yLoc);
            multiFrame.setSize(width,height);
	   		multiFrame.setVisible(true);

            return multiFrame;                                                   //return to calling point Constructor
	    }

 /***********************************Create Menubar Method**************************************************/
        public JMenuBar createMenuBar()                             //menubar method
         {
	        JMenuBar menuBar = new JMenuBar();                   //create menubar
	        JMenu menu = new JMenu("MENU");                      //create menu
	        menuBar.add(menu);                                   //add menu component to menubar
	        JMenuItem menuItem = new JMenuItem("New");           //create a menu Item (3 off)
	        JMenuItem menuItem2 = new JMenuItem("Save");
	        JMenuItem menuItem3 = new JMenuItem("Close");
	        menu.add(menuItem);                                  //add menu items to the menu
	        menu.add(menuItem2);
	        menu.add(menuItem3);

            return menuBar;                                      //return the created menubar to the calling point
	     }


}   //end of class