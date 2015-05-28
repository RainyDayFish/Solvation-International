import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.io.*;

public class Test {
  static ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem>();
  
  public static void main (String[]args){
    JFrame f = new JFrame ();
    Test.items.add (new CoverFlowMenuItem ("1.png", "World 1 (Easy)", true, KeyEvent.VK_P));
    Test.items.add (new CoverFlowMenuItem ("2.png", "World 2 (Medium)", true, KeyEvent.VK_H));
    Test.items.add (new CoverFlowMenuItem ("3.png", "World 3 (Hard)", true, KeyEvent.VK_S));
    //Test.items.add (new CoverFlowMenuItem ("help.png", "Help", true, KeyEvent.VK_H));
    //Test.items.add (new CoverFlowMenuItem ("quit.png", "Quit", true, KeyEvent.VK_Q));
    
    CoverFlowMenu menu = new CoverFlowMenu (Test.items, "World Selection");
    f.add (menu);
    
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.pack ();
    f.setVisible (true);
    
    System.out.println (menu.getChoice ());
  }
}