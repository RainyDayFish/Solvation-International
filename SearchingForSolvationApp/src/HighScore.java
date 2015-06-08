import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.*;

public class HighScore implements Printable {
  
  static ArrayList <Score> highScores = new ArrayList <Score> ();
  static final String SCORE_FILE_PATH = "./resources/user/high_scores.txt";
  private PrinterJob job = PrinterJob.getPrinterJob ();
  private BufferedReader in;
  
  public boolean isHighScore (Score score){
    if (highScores.size () < 10 || highScores.get (highScores.size () - 1).compareTo (score) < 0)
      return true;
    return false;
  }
  
  public void addHighScore (Score score){
    if (highScores.size () < 10)
      highScores.add (score);
    else
    {
      highScores.set (9, score);
      Collections.sort (highScores);
    }
  }
  
  public void saveHighScores (){
    try {
      PrintWriter out = new PrintWriter (new FileWriter (SCORE_FILE_PATH));
      
      out.println ("Solvata High Scores");
      
      for (Score i : highScores){
        out.println (i.getName ());
        out.println (i.getDifficulty ());
        out.println (i.getLevel ());
        out.println (i.getScore ());
      }
      out.close ();
    }
    catch (IOException e){
    }
  }
  
  public boolean readHighScores (){
    try {
      in = new BufferedReader (new FileReader (SCORE_FILE_PATH));
      Score x;
      
      highScores.clear ();
      
      if (!in.readLine ().equals ("Solvata High Scores"))
        return false;
      System.out.println ("first line is correct");
      
      x = readScore ();
      System.out.println ("read first score");
      
      while (isValidScore (x)){
        System.out.println ("score is correct");
        if (!highScores.isEmpty () && highScores.get (highScores.size () - 1).compareTo (x) < 0){ //IF HIGH SCORES ARE NOT STORED IN ORDER...
          System.out.println ("score is not stored in order");
          return false;
        }
        
        System.out.println ("score added!");
        highScores.add (x);
        x = readScore ();
      }
      
      if (isValidName (x.getName ()) && !isValidScore (x)) //WHETHER OR NOT THE SCORE OBJECT IS INVALID OR IF THE FILE SIMPLY ENDED
        return false;
    }
    catch (IOException e){
      return false;
    }
    return true;
  }
  
  private Score readScore (/*BufferedReader in*/){
    Score score = new Score ("", -1, -1, -1);
    String line = "";
    
    try {
      System.out.println ("reading name");
      line = in.readLine ();
      score.setName (line);
      
      if (!isValidName (line))
        return score;
      
      System.out.println ("reading difficulty");
      line = in.readLine ();
      
      // if (isValidDifficulty (Integer.parseInt (line)))
      score.setDifficulty (Integer.parseInt (line));
      //  else
      //   return null;
      System.out.println ("reading level");
      line = in.readLine ();
      
      score.setLevel (Integer.parseInt (line));
      
      System.out.println ("reading score");
      line = in.readLine ();
      
      //   if (isValidScore (Integer.parseInt (line)))
      score.setScore (Integer.parseInt (line));
      //   else
      //    return null;
    }
    catch (IOException | NumberFormatException e){
      System.out.println ("error");
      return null;
    }
    return score;
  }
  
  private boolean isValidName (String name){
    System.out.println ("name: " + name + " validity: " + name != null);
    return name != null;
  }
  
  private boolean isValidDifficulty (int difficulty){
    System.out.println ("difficulty: " + difficulty + " validity: " + (0 <= difficulty && difficulty <= 2));
    return 0 <= difficulty && difficulty <= 2;
  }
  
  private boolean isValidScore (int score){
    System.out.println ("score: " + score + " validity: " + (0 <= score));
    return 0 <= score;
  }
  
  private boolean isValidLevel (int level){
    System.out.println ("level: " + level + " validity: " + (0 <= level));
    return 0 <= level;
  }
  
  private boolean isValidScore (Score score){
    return score != null && isValidName (score.getName ()) && isValidDifficulty (score.getDifficulty ()) && isValidLevel (score.getLevel ()) && isValidScore (score.getScore ());
  }
  
  public int print (Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException
  {
    Graphics g2d = (Graphics2D)g;
    
    if (pageIndex > 0)
      return NO_SUCH_PAGE;
    
    g2d.translate ((int) pageFormat.getImageableX (), (int) pageFormat.getImageableY ());
    
    g.setFont (new Font ("Arial", Font.BOLD, 18));
    g.setColor (Color.BLACK);
    
    g.drawString ("High Scores", (int) (pageFormat.getImageableHeight () / 2), 100);
    
    g.setFont (new Font ("Arial", Font.BOLD, 13));
    
    g.drawString ("#", 20, 150);
    g.drawString ("Name", 50, 150);
    g.drawString ("World", 125, 150);
    g.drawString ("Score", 200, 150);
    
    g.setFont (new Font ("Arial", Font.PLAIN, 12));
    
    for (int i = 0; i < highScores.size (); i++){
      Score x = highScores.get (i);
      
      g.drawString ("#" + (i + 1), 20 , i * 30 + 175);
      g.drawString (x.getName (), 50 , i * 30 + 175);
      g.drawString ("" + x.getDifficulty (), 125 , i * 30 + 175);
      g.drawString ("" + x.getScore (), 200 , i * 30 + 175);
    }
    return PAGE_EXISTS;
  }
  
  public boolean printer (){
    if (job.printDialog ()){
      try {
        job.print ();
        return true;
      }
      catch (PrinterException e){
        JOptionPane.showMessageDialog (null, "There was an error printing. Please try again.", "Printer Error", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    return false;
  }
  
  public HighScore (){
    job.setPrintable (this);
  }
}