import java.util.*;
import java.awt.*;

public class GameLevel
{
  private int levelNum;
  private double timeLimit;
  private BufferedImage background;
  private List < Platform > platforms;
  private List <Questions> questions;
  public int getLevelNum ()
  {
    return levelNum;
  }
  
  
  public double getTimeLimit ()
  {
    return timeLimit;
  }
  
  public BufferedImage getBackground (){
    return background;
  }
  
  
  public List < Platform > getPlatforms ()
  {
    return platforms;
  }
  
  public List <Question> getQuestions(){
    return questions;
  }
  
  public void generatePlatforms (int difficultyLevel)
  {
  }
  public void removeP(int num){
    platforms.remove(num);
  }
  public int getLowest(){
    int low=platforms.get(0).getY();
    for(Platform a:platforms){
      if(a.getY()>low){
        low=a.getY();
        
      }
      return low;
    }
    public int getHighest(){
         int high=platforms.get(0).getY();
    for(Platform a:platforms){
      if(a.getY()<high){
        high=a.getY();
        
      }
      return high;
      
    }
  }
  public void cleanP(){
    for(Platform a:platforms){
      if(a.getY()>500){
        a.setY(getHighest()-a.getY()+500);
      }
      
    }
    
  }
  public GameLevel (int levelNum, double timeLimit, BufferedImage background)
  {
    this.levelNum = levelNum;
    this.timeLimit = timeLimit;
    this.background = background;
  }
}
