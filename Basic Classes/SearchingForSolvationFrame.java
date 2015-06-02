import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SearchingForSolvationFrame/* extends JFrame*/ {
  static Game game;
  static JFrame frame;
  
  public void quitProgram (){
    frame.dispose ();
    System.exit (0);
  }
  
  public SearchingForSolvationFrame (){
    frame = new JFrame ("test");
    //super ("Solvation - Searching For Solvation");
    
    try {
      UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    }
    catch (Exception e){
    }
    
    frame.setSize (Utilities.SCREEN_SIZE, Utilities.SCREEN_SIZE);
    frame.setResizable (false);
    frame.setLocationRelativeTo (null);
    frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
    
    frame.addWindowListener (new WindowAdapter () {
      public void windowClosing (WindowEvent ev){
        quitProgram ();
      }});
    
    List <GameLevel> levels = new ArrayList <GameLevel> ();
    levels.add (new GameLevel (1, 500, Utilities.CLOUDS_BACKGROUND, true));
    
    game = new Game (new Player (250, 0, true, Utilities.TEMP_SPRITE), new World (1,  levels));
    
    frame.add (new Draw ());
    
    frame.pack ();
    frame.setVisible (true);
    
    new GameGUI ().runGame ();
  }
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