import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.*;

public class HighScore implements Printable {
  
  static ArrayList <Score> highScores = new ArrayList <Score> ();
  private PrinterJob job = PrinterJob.getPrinterJob ();
  
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
      PrintWriter out = new PrintWriter (new FileWriter ("high_scores.txt"));
      
      for (Score i : highScores){
        out.println (i.getName ());
        out.println (i.getDifficulty ());
        out.println (i.getScore ());
      }
      out.close ();
    }
    catch (IOException e){
    }
  }
  
  public boolean readHighScores (){
    try {
      BufferedReader in = new BufferedReader (new FileReader ("high_scores.txt"));
      Score x;
      
      highScores.clear ();
      
      while ((x = readScore (in)) != null && x.getName () != null){
        highScores.add (x);
      }
      
      if (x == null || highScores.get (highScores.size () - 1).compareTo (x) < 0)
        return false;
    }
    catch (IOException e){
      return false;
    }
    return true;
  }
  
  private Score readScore (BufferedReader in){
    Score score = new Score ("", -1, -1);
    String line = "";
    
    try {
      line = in.readLine ();
      score.setName (line);
      
      if (line == null)
        return score;
      
      line = in.readLine ();
      
      if (isValidDifficulty (Integer.parseInt (line)))
        score.setDifficulty (Integer.parseInt (line));
      else
        return null;
      
      line = in.readLine ();
      
      if (isValidScore (Integer.parseInt (line)))
        score.setScore (Integer.parseInt (line));
      else
        return null;
    }
    catch (IOException | NumberFormatException e){
      return null;
    }
    return score;
  }
  
  private boolean isValidName (String name){
    return name != null;
  }
  
  private boolean isValidDifficulty (int difficulty){
    return 0 <= difficulty && difficulty <= 2;
  }
  
  private boolean isValidScore (int score){
    return score >= 0;
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
        return false;
      }
    }
    return false;
  } 
}