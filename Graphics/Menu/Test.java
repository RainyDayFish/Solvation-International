import java.util.*;
import javax.swing.*;

public class Test {
  static ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem>();
  
  public static void main (String[]args){
    JFrame f = new JFrame ();
    Test.items.add (new CoverFlowMenuItem ("B6.jpg", "Barter 6", true));
    Test.items.add (new CoverFlowMenuItem ("C3.jpg", "Tha Carter III", true));
    Test.items.add (new CoverFlowMenuItem ("TC.jpg", "Take Care", true));
    Test.items.add (new CoverFlowMenuItem ("Graduation.jpg", "Graduation", false));
    
    CoverFlowMenu menu = new CoverFlowMenu (Test.items,"Album Selection");
    f.add (menu);
    
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.pack ();
    f.setVisible (true);
    
    System.out.println (menu.getChoice ());
  }
}