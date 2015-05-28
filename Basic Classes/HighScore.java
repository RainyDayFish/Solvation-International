import java.util.*;
import java.io.*;
import javax.swing.*;

public class HighScore {
  
  static List <Score> highScore = new ArrayList <Score> ();
  
  public static List <Score> sortScores (){
    List <Score> sorted = new ArrayList <Score> (highScore);
    
    for (int i = 1; i < sorted.size (); i++){
      Score score = sorted.get (i);
      int j;
      
      for (j = i - 1; j >= 0 && score.getScore () < sorted.get (j).getScore () ; j--){
        sorted.set (j + 1, sorted.get (j));
      }
      sorted.set (j + 1, score);
    }
    
    return sorted;
  }
  
  public static boolean isHighScore (Score score){
    if (highScore.isEmpty () || highScore.get (highScore.size () - 1).getScore () < score.getScore ())
      return true;
    return false;
  }
  
  public static void addScore (Score score){
    if (highScore.isEmpty ())
      highScore.add (score);
    else{
      highScore.set (highScore.size () - 1, score);
      sortScores ();
    }
  }
  
  public static void saveHighScores (){
    try {
      PrintWriter out = new PrintWriter (new FileWriter ("high_scores.txt"));
      out.println ("High Scores - Solvata");
      
      if (!highScore.isEmpty ()){
        for (Score i : highScore){
          out.println (i.getName ());
          out.println (i.getScore ());
          out.println (i.getDifficulty ());
        }
      }
      out.close ();
    }
    catch (IOException e){
      JOptionPane.showMessageDialog (null, "An error occurred while saving high scores.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public static void readHighScores (){
    String msg = "An error with the high scores occurred. A new file will be created.";
    boolean successful = true;
    Score score;
    
    try {
      BufferedReader in = new BufferedReader (new FileReader ("high_scores.txt"));
      String line = in.readLine ();
      int i = 0;
      
      if (line == null || !line.equals ("High Scores - Solvata"))
        successful = false;
      
      highScore.clear ();
      
      if (successful){
        while (i < 10){
          score = getScoreFromFile (in);
          
          if (score == null || score.getName () == null){ //if the score is null, then the score is invalid. if the score NAME is null, then there are no more scores and the reading should be stopped
            if (score == null)
              successful = false;
            break;
          }          
          highScore.add (score);
          i++;
        }
      }
    }
    catch (IOException e){
      msg = "No high scores were found. A new file will be created.";
      successful = false;
    }
    
    if (!highScore.equals (sortScores ()))
      successful = false;
    
    if (!successful){
      JOptionPane.showMessageDialog (null, msg, "High Score Error", JOptionPane.ERROR_MESSAGE);
      saveHighScores ();
    }
  }
  
  public static Score getScoreFromFile (BufferedReader in){
    String line = "";
    Score score = new Score (null, -1, -1);
    
    try {
      for (int i = 0; i < 3; i++){
        line = in.readLine ();
        
        if (i == 0){ //reading the line of the file storing the player name
          score.setName (line);
          
          if (line == null)//if the name is null, there are no more high scores to read, thus return a Score with a null name
            return score;
        }
        else {
          if (Integer.parseInt (line) < 0)//if the int is less than 0, then the score is not valid, return null
            return null;
          
          if (i == 1){//if i == 1, then the program is reading the 'score' part of the player score
            score.setScore (Integer.parseInt (line));
          }
          else{
            if (i == 2){//if i == 2, then the program is reading the difficulty level of the player score
              if (Integer.parseInt (line) > 2)//if the difficulty level is above 2, then the score is invalid (easy == 0, medium == 1, hard == 2) NOTE THAT the int is already verified to be above 0, based on the earlier check
                return null;
              score.setDifficulty (Integer.parseInt (line));
            }
          }
        }
      }
    }
    catch (IOException | NumberFormatException e){//if an IOException/NumberFormatException occurred, the score is invalid, thus returning null
      return null;
    }
    return score;//return the correct score
  }
  
  private HighScore (){}
}