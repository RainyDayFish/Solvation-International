import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
public class SearchingForSolvationFrame/* extends JFrame*/ {
  static Game game=new Game();
  static JFrame frame;
  
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
//    
//    List <GameLevel> levels = new ArrayList <GameLevel> ();
//    levels.add (new GameLevel (1, 500, Utilities.CLOUDS_BACKGROUND, true));
//    
//    game = new Game (new Player (250, 0, true, Utilities.TEMP_SPRITE), new World (1,  levels));
//    
//    frame.add (new Draw ());
    //game=Game.run(1,game,"Snail");
    //frame.add (new Draw ());
    
    //splashScreen();
    
    while(true){
      // frame.getContentPane().removeAll();
      action(mainMenu ());
    }
    //new GameGUI ().runGame ();
  }
//  private void music(){
//  Utilities.BMUSIC.loop();
//  try{
//  Thread.sleep(1000);
//  }catch(Exception e){
//  
//  }
//  }
  public int mainMenu(){
    frame.getContentPane().removeAll();
    //  Utilities.refreshScreen ();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.PLAY_BUTTON, "Play", true, KeyEvent.VK_P));
    items.add  (new CoverFlowMenuItem (Utilities.HELP_BUTTON, "Help", true, KeyEvent.VK_H));
    items.add  (new CoverFlowMenuItem (Utilities.SETTINGS_BUTTON, "Settings", true,  KeyEvent.VK_S));
    items.add  (new CoverFlowMenuItem (Utilities.HIGH_SCORE_BUTTON, "High Scores",  true,  KeyEvent.VK_H));
    items.add  (new CoverFlowMenuItem (Utilities.QUIT_BUTTON, "Quit", true, KeyEvent.VK_Q));
    
    CoverFlowMenu menu = new CoverFlowMenu (items, "Main Menu");
    
    frame.add (menu);
    menu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    int choice= menu.getChoice ();
    Utilities.refreshScreen ();
    return choice;
    
  }
  
  public void action(int choice){
    if(choice==0){
      play();
    }else if(choice==1){
      help();
    }else if(choice==2){
      setting();
    }else if(choice==3){
      score();
    }else{
      quit();
    }
    
  }
  
  private void play(){
    frame.getContentPane().removeAll();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.PLUS_BUTTON, "Start New", true, KeyEvent.VK_N));
    items.add  (new CoverFlowMenuItem (Utilities.TRAVEL_BUTTON, "Choose World", true, KeyEvent.VK_P));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back", true, KeyEvent.VK_B));
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Play Menu");
    
    frame.add (sideMenu);
    Utilities.refreshScreen ();
    sideMenu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    int choice= sideMenu.getChoice ();
    Utilities.refreshScreen ();
    if(choice==0){
      System.out.println("reached game");
      game=Game.run(1,game,charSelect());
      frame.getContentPane().removeAll();
      System.out.println("pasted game");
      frame.add (new Draw ());
      frame.pack ();
      frame.setVisible (true);
      
      new GameGUI ().runGame ();
      if(game.getWon()==true){
        
      }
      worldSelect();
    }else{
      if(choice==1){
        worldSelect();
      }
    }
  }
  private void worldSelect(){
    frame.getContentPane().removeAll();
    // Utilities.refreshScreen ();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.CANADA_BUTTON, "Canada", true, KeyEvent.VK_C));
    items.add  (new CoverFlowMenuItem (Utilities.ASIA_BUTTON, "Asia", true, KeyEvent.VK_A));
    items.add  (new CoverFlowMenuItem (Utilities.WORLD_BUTTON, "The World", true,  KeyEvent.VK_T));
    
    CoverFlowMenu menu = new CoverFlowMenu (items, "World Menu");
    
    frame.add (menu);
    menu.requestFocus();
    frame.pack();
    frame.setVisible (true);
    
    int choice= menu.getChoice ();
    Utilities.refreshScreen ();
    System.out.println("Real Game Reached");
    game=Game.run(choice+1,game,charSelect());
    frame.getContentPane().removeAll();
    System.out.println("past game");
    frame.add (new Draw ());
    frame.pack ();
    frame.setVisible (true);
    
    new GameGUI ().runGame ();
  }
  
  private String charSelect(){
    frame.getContentPane().removeAll();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.DOT_BUTTON, "Dot", true, KeyEvent.VK_D));
    items.add  (new CoverFlowMenuItem (Utilities.SNAIL_BUTTON, "Snail", true, KeyEvent.VK_S));
    
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Play Menu");
    
    frame.add (sideMenu);
    sideMenu.requestFocus();
    frame.pack();
    int choice= sideMenu.getChoice ();
    if(choice==0){
      return "dot";
    }else{
      System.out.println("chosen");
      return "Snail";
    }
  }
  private void help(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.HELP, -1);
    frame.add(f);
    f.requestFocus();
    // frame.pack();
    frame.setVisible (true);
    Utilities.refreshScreen ();
    System.out.println("flase");
    f.getBack();
    System.out.println("flase@");
  }
  
  private void setting(){
    frame.getContentPane().removeAll();
    ArrayList <CoverFlowMenuItem> items = new ArrayList <CoverFlowMenuItem> ();
    items.add  (new CoverFlowMenuItem (Utilities.SOUND_BUTTON, "Turn Sound On/Off", true, KeyEvent.VK_T));
    items.add  (new CoverFlowMenuItem (Utilities.BIO_BUTTON, "Biography", true, KeyEvent.VK_B));
    items.add  (new CoverFlowMenuItem (Utilities.BACK_BUTTON, "Back", true, KeyEvent.VK_B));
    
    
    CoverFlowMenu sideMenu = new CoverFlowMenu (items, "Settings");
    
    frame.add (sideMenu);
    sideMenu.requestFocus();
    frame.pack();
    Utilities.refreshScreen ();
    int choice= sideMenu.getChoice ();
    if(choice==0){
      System.out.println("working on it");
      
    }else if(choice==1){
      
      bio();
    }else{
      
    }
  }
  private void score(){
    
  }
  private void quit(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.GOODBYE, 15);
    frame.add(f);
    f.requestFocus();
    frame.setVisible (true);
    Utilities.refreshScreen ();
    f.getBack();
    System.exit(0);
  }
  private void splashScreen(){
    
    frame.add(new DrawImage());
    frame.pack();
    frame.setVisible (true);
    try{
      Thread.sleep(15000);
    }catch(Exception e){
      
    }
    
  }
  private void bio(){
    frame.getContentPane().removeAll();
    DrawPic f=new DrawPic(Utilities.BIO, -1);
    frame.add(f);
    f.requestFocus();
    frame.setVisible (true);
    Utilities.refreshScreen ();
    f.getBack();
    setting();
  }
//  public static void main(String args[]){
//    Game g;
//    try{
//      List <GameLevel> levels = new ArrayList <GameLevel> ();
//      levels.add (new GameLevel (1, 500, Utilities.CLOUDS_BACKGROUND, true));
//      g = new Game (new Player (250, 0, true, Utilities.TEMP_SPRITE), new World (1,  levels));
//      //   for(Platform a:Game.getLevel().getPlatforms()){
//      // System.out.println(a.getX());
//      //  }
//      g.drawGame ();
//      g.inGame ();
//    }
//    catch (IOException e){
//      System.out.println ("no files");
//    }
//  }
//  
//  public void drawGame(){
//    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//    f.add (new Draw());
//    f.pack ();
//    f.setVisible (true);
//  }
}
