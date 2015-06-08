import javax.swing.*;

public class GameGUI extends JPanel {
  
  public GameGUI (){
  }
  
  public void highScores(){
    
  }
  
  public void options(){
    
  }
  
  public void help(){
    //game.pauseGame();
  }
  
  public void quitGame(){
    int choice = saveOptions();
    
    if(choice==0){
      saveGame();
      System.exit(0);
    }
    
    if(choice==1){
      System.exit(0);
    }
  }
  
  public void playGame(){
    
  }
  
  public void runGame (){
    SearchingForSolvationFrame.game.setTimeLeft (SearchingForSolvationFrame.game.getWorld ().getLevel (SearchingForSolvationFrame.game.getCurrentLevel ()).getTimeLimit ());
    
    while (SearchingForSolvationFrame.game.getPlayer ().getLives () > 0 /*&& !SearchingForSolvationFrame.game.updateGameState ()*/){
      
      if(SearchingForSolvationFrame.game.updateGameState ()){
        break;
      }
      Utilities.refreshScreen ();
      
      //System.out.println ("test " + SearchingForSolvationFrame.game.getTimeLeft () + " " + SearchingForSolvationFrame.game.getPlayer ().getLives ());
      Utilities.delay (50);
    }
  }
  
  public void newGame(){
    
  }
  
  public void openGame(){
    
  }
  
  public void  selectCharacter(){
    
  }
  
  public void selectDiff(){
    
  }
  
  public void saveGame(){
    
  }
  
  private int saveOptions(){
    return 1;
  }
}