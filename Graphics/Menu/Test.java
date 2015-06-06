import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.io.*;

public class Test {
  static ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem>();
  
  public static void main (String[]args){
    JFrame f = new JFrame ();
    Test.items.add (new CoverFlowMenuItem (Utilities.PLAY_BUTTON, "Play", true, KeyEvent.VK_P));
    Test.items.add (new CoverFlowMenuItem (Utilities.HELP_BUTTON, "Help", true, KeyEvent.VK_H));
    Test.items.add (new CoverFlowMenuItem (Utilities.QUIT_BUTTON, "Quit", true, KeyEvent.VK_S));
    
    CoverFlowMenu menu = new CoverFlowMenu (Test.items, "World Selection");
    f.add (menu);
    
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.pack ();
    f.setVisible (true);
      
    
    System.out.println (menu.getChoice ());
  }
}
