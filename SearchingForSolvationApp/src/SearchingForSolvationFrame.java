import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;

public class SearchingForSolvationFrame/* extends JFrame*/ {
  static Game game = new Game ();
  static JFrame frame;
  
  private int choice = 0;
  
  public void quitProgram (){
    frame.dispose ();
    System.exit (0);
  }
  
  public SearchingForSolvationFrame (){
    frame = new JFrame ("Searching for Solvation");
    //super ("Solvation - Searching For Solvation");
    
    try {
      UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    }
    catch (Exception e){
    }
    
    frame.setSize (Utilities.SCREEN_W, Utilities.SCREEN_H);
    frame.setResizable (false);
    frame.setLocationRelativeTo (null);
    frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
    
    frame.addWindowListener (new WindowAdapter () {
      public void windowClosing (WindowEvent ev){
        quitProgram ();
      }});
    
    Utilities.startup ();
    
    do {
      mainMenu ();
      
      if (choice == 0){
        play ();
      }
      else if (choice == 1){
        help ();
      }
      else if (choice == 2){
        setting ();
      }
      else if (choice == 3){
        score ();
      }
      else {
        if (choice == -1){
          quitProgram ();
        }
      }
    }
    while (choice != -1);
  }
  
  public void mainMenu(){
    frame.getContentPane().removeAll();
    //  Utilities.refreshScreen ();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.PLAY_BUTTON, "Play", true, KeyEvent.VK_P));
    items.add  (new CoverFlowMenuItem (Utilities.HELP_BUTTON, "Help", true, KeyEvent.VK_H));
    items.add  (new CoverFlowMenuItem (Utilities.SETTINGS_BUTTON, "Settings", true, KeyEvent.VK_S));
    items.add  (new CoverFlowMenuItem (Utilities.HIGH_SCORE_BUTTON, "High Scores", true, KeyEvent.VK_H));
    items.add  (new CoverFlowMenuItem (Utilities.QUIT_BUTTON, "Quit", true, KeyEvent.VK_Q));
    
    CoverFlowMenu menu = new CoverFlowMenu (items, "Main Menu");
    
    frame.add (menu);
    menu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    choice = menu.getChoice ();
    //Utilities.refreshScreen ();
    if (choice == 4)
      choice = -1;
  }
  
  private void play (){
    frame.getContentPane().removeAll();
    
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    
    items.add  (new CoverFlowMenuItem (Utilities.TRAVEL_BUTTON, "Choose World", true, KeyEvent.VK_C));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back to Main Menu", true, KeyEvent.VK_B));
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Play Menu");
    
    frame.add (sideMenu);
    //Utilities.refreshScreen ();
    sideMenu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    choice = sideMenu.getChoice ();
    
    if (choice == 0){
      worldSelect ();
    }
  }
  
  private void result(){
    frame.getContentPane().removeAll();
    DrawPic f;
    
    if(game.getWon()){
      f = new DrawPic(Utilities.WON, 5);
    }
    else{
      f = new DrawPic(Utilities.LOST, 5);
    }
    
    frame.add(f);
    f.requestFocus();
    // frame.pack();
    frame.setVisible (true);
    //Utilities.refreshScreen ();
    //   System.out.println("flase");
    f.getBack();
    // System.out.println("flase@");
  }
  
  private void worldSelect(){
    frame.getContentPane().removeAll();
    // Utilities.refreshScreen ();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    
    items.add  (new CoverFlowMenuItem (Utilities.CANADA_BUTTON, "Canada (Easy)", true, KeyEvent.VK_C));
    items.add  (new CoverFlowMenuItem (Utilities.ASIA_BUTTON, "Asia (Medium)", true, KeyEvent.VK_A));
    items.add  (new CoverFlowMenuItem (Utilities.WORLD_BUTTON, "International (Hard)", true, KeyEvent.VK_T));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back to Main Menu", true, KeyEvent.VK_B));
    
    CoverFlowMenu menu = new CoverFlowMenu (items, "World/Difficulty Menu");
    
    frame.add (menu);
    menu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    choice = menu.getChoice ();
    System.out.println ("world choice: " + choice);
    if (choice != 3){
      BufferedImage sprite = charSelect ();
      
      if (sprite != null){
        String name = getNameInput ();
        
        if (name != null){
          startGame (sprite, name, choice);
          result ();
        }
      }
    }
  }
  
  private void startGame (BufferedImage img, String name, int choice) {
    game = game.run (choice + 1, img, name);
    System.out.println ("after run () method");
    frame.getContentPane ().removeAll ();
    
    frame.add (new Draw ());
    frame.pack ();
    frame.setVisible (true);
    
    System.out.println ("BEFORE running game");
    new GameGUI ().runGame ();
  }
  
  private BufferedImage charSelect(){
    frame.getContentPane().removeAll();
    
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    
    items.add  (new CoverFlowMenuItem (Utilities.DOT_BUTTON, "Eye", true, KeyEvent.VK_E));
    items.add  (new CoverFlowMenuItem (Utilities.SNAIL_BUTTON, "Snail", true, KeyEvent.VK_S));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back to Main Menu", true, KeyEvent.VK_B));
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Play Menu");
    
    frame.add (sideMenu);
    sideMenu.requestFocus();
    frame.pack();
    
    int option = sideMenu.getChoice ();
    
    if(option == 0){
      System.out.println ("eye: " + Utilities.DOT_L);
      return Utilities.DOT_L;
    }
    else if (option == 1){
      System.out.println ("snail: " + Utilities.DOT_L);
      return Utilities.SNAIL_L;
    }
    else{
      System.out.println ("choice is null");
      return null;
    }
  }
  
  private void help(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.HELP, -1);
    frame.add(f);
    f.requestFocus();
    // frame.pack();
    frame.setVisible (true);
    //Utilities.refreshScreen ();
    System.out.println("flase");
    f.getBack();
    System.out.println("flase@");
  }
  
  private String getNameInput (){
    String x;
    
    while (true){
      x = JOptionPane.showInputDialog (null, "Please input a name (1-16 characters).", "Name");
      
      if (x == null || x.trim ().length () > 0 && x.trim ().length () < 17){
        break;
      }
      JOptionPane.showMessageDialog (null, "Name must be between 1-16 characters long.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
    }
    return x;
  }
  
  private void setting(){
    frame.getContentPane().removeAll();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.SOUND_BUTTON, "Turn Sound On/Off", true, KeyEvent.VK_T));
    items.add  (new CoverFlowMenuItem (Utilities.BIO_BUTTON, "Biography", true, KeyEvent.VK_B));
    items.add  (new CoverFlowMenuItem (Utilities.PRINT_BUTTON, "Print High Scores", HighScore.highScores.size () > 0, KeyEvent.VK_P));
    items.add  (new CoverFlowMenuItem (Utilities.CLEAR_BUTTON, "Clear High Scores", HighScore.highScores.size () > 0, KeyEvent.VK_C));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back", true, KeyEvent.VK_B));
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Settings");
    
    frame.add (sideMenu);
    sideMenu.requestFocus();
    frame.pack();
    //Utilities.refreshScreen ();
    int choice= sideMenu.getChoice ();
    if(choice == 0){
      System.out.println("working on it");
    }
    else if (choice == 1){
      bio ();
    }
    else if (choice == 2){
      new HighScore ().printer ();
    }
    else{
      if (choice == 3){
        HighScore.highScores.clear ();
        new HighScore ().saveHighScores ();
      }
    }
  }
  
  private void score(){
    frame.getContentPane ().removeAll ();
    DrawPic f = new DrawPic (Utilities.BLANK_SCORES, 15);
    f.addScores ();
    
    frame.add (f);
    f.requestFocus ();
    frame.setVisible (true);
    
    f.getBack ();
  }
  
  private void quit(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.GOODBYE, 1000);
    frame.add(f);
    f.requestFocus();
    frame.setVisible (true);
    //Utilities.refreshScreen ();
    f.getBack();
    System.exit(0);
  }
  
  private void splashScreen(){
    // frame.setUndecorated(true);
    frame.add(new DrawImage());
    Utilities.refreshScreen ();
    //frame.pack();
    frame.setVisible (true);
    /*try{
      //Thread.sleep(15000);
      Thread.sleep (15000);
    }
    catch(Exception e){
      
    }*/
    Utilities.delay (15000);
  }
  
  private void bio(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.BIO, -1);
    frame.add(f);
    f.requestFocus();
    frame.setVisible (true);
    //Utilities.refreshScreen ();
    f.getBack();
    setting();
  }
}