import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Test {
  static ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem>();
  
  public static void main (String[]args){
    JFrame f = new JFrame ();
    Test.items.add (new CoverFlowMenuItem ("play.png", "Play", true, KeyEvent.VK_P));
    Test.items.add (new CoverFlowMenuItem ("scores.png", "High Scores", true, KeyEvent.VK_H));
    Test.items.add (new CoverFlowMenuItem ("settings.png", "Settings", true, KeyEvent.VK_S));
    Test.items.add (new CoverFlowMenuItem ("help.png", "Help", true, KeyEvent.VK_H));
    Test.items.add (new CoverFlowMenuItem ("quit.png", "Quit", true, KeyEvent.VK_Q));
    
    CoverFlowMenu menu = new CoverFlowMenu (Test.items,"Main Menu");
    f.add (menu);
    
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.pack ();
    f.setVisible (true);
    
    System.out.println (menu.getChoice ());
  }
}