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
  
  
  public GameLevel (int levelNum, double timeLimit, BufferedImage background)
  {
    this.levelNum = levelNum;
    this.timeLimit = timeLimit;
    this.background = background;
  }
}
