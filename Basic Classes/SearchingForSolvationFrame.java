import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SearchingForSolvationFrame extends JFrame {
  static Game game;
  
  public void quitProgram (){
    dispose ();
  }
  
  public SearchingForSolvationFrame (){
    super ("Solvation - Searching For Solvation");
    
    try {
      UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    }
    catch (Exception e){
    }
    
    setSize (Utilities.SCREEN_SIZE, Utilities.SCREEN_SIZE);
    setResizable (false);
    setLocationRelativeTo (null);
    setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
    
    this.addWindowListener (new WindowAdapter () {
      public void windowClosing (WindowEvent ev){
        quitProgram ();
      }});
    
    List <GameLevel> levels = new ArrayList <GameLevel> ();
    levels.add (new GameLevel (1, 500, Utilities.CLOUDS_BACKGROUND, true));
    
    game = new Game (new Player (250, 0, true, Utilities.TEMP_SPRITE), new World (1,  levels));
    
    add (new Draw ());
    pack ();
    setVisible (true);
    game.inGame ();
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