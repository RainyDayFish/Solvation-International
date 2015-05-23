import java.util.*;
import java.awt.image.BufferedImage;

/* This class is used to instantiate various levels of the game for the user to play.
 * 
 * @author Atharva Washimkar
 * @version 1 05.22.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>levelNum</b> An int which specifies which level the player is on.
 * <p>
 * <b>timeLimit</b> A double which specifies the amount of time that the user has to complete the level.
 * <p>
 * <b>background</b> A BufferedImage which is used to visually represent the level on the screen.
 * <p>
 * <b>platforms</b> A List of Platforms which contain the amount of Platforms within the level.
 * <p>
 * <b>questions</b> A List of Question objects which are asked by the program and are answered by the user during the level.
 */

public class GameLevel
{
  private int levelNum;
  private double timeLimit;
  private BufferedImage background;
  private List < Platform > platforms;
  private List <Question> questions;
  
  /* Description of getLevelNum ()
   * This method returns an int which represents the level number.
   *
   * @return An int which represents the level number.
   */
  
  public int getLevelNum ()
  {
    return levelNum;
  }
  
  /* Description of getTimeLimit ()
   * This method returns a double value which represents the amount of time the user has to complete the level.
   *
   * @return A double value which represents the amount of time the user has to complete the level.
   */
  
  public double getTimeLimit ()
  {
    return timeLimit;
  }
  
  /* Description of getBackground ()
   * This method returns a BufferedImage which visually represents the level on the screen.
   *
   * @return A Buffered image which visually represents the level on the screen.
   */
  
  public BufferedImage getBackground (){
    return background;
  }
  
  /* Description of getPlatforms ()
   * This method returns a List of Platforms which represents the Platform objects on the screen.
   *
   * @return A List of Platforms which represents the Platform objects on the screen.
   */
  
  public List < Platform > getPlatforms ()
  {
    return platforms;
  }
  
  /* Description of getQuestions ()
   * This method returns a List of Questions which represents the questions asked to the user during the level.
   *
   * @return A List of Questions which represents the questions asked to the user during the level.
   */
  
  public List <Question> getQuestions(){
    return questions;
  }
  
  /* Description of generatePlatforms ()
   * This method assigns values to the List of Platforms based on the difficulty level of the level.
   */
  
  public void generatePlatforms (int difficultyLevel)
  {
  }
  
  /* Description of removePlatform ()
   * This method removes a certain index passed as a parameter from the Platform List.
   *
   * @param num An int which represents the index to remove within the platforms List.
   */
  
  public void removePlatform (int num){
    platforms.remove(num);
  }
  
  /* Description of getLowest ()
   * This method returns the y value of the lowest Platform object within a List.
   *
   * @return An int which represents the y value of the lowest Platform object within a List.
   */
  
  public int getLowest (){
    int low=platforms.get(0).getY();
    for(Platform a:platforms){
      if(a.getY()>low){
        low=a.getY();
      }
    }
    return low;
  }
  
  /* Description of getLowest ()
   * This method returns the y value of the highest Platform object within a List.
   *
   * @return An int which represents the y value of the highest Platform object within a List.
   */
  
  public int getHighest(){
    int high=platforms.get(0).getY();
    for(Platform a:platforms){
      if(a.getY()<high){
        high=a.getY();
      }
    }
    return high;
  }
  
  /* Description of cleanPlatform ()
   * This method checks if a Platform's y value is off the screen, and if so, re-adds it to the top.
   */
  
  public void cleanPlatform (){
    for(Platform a:platforms){
      if(a.getY()>500){
        a.setY(getHighest()-a.getY()+500);
      }
    }
  }
  
  /* 
   * This constructors creates a new GameLevel with the attributes of levelNum, the time limit and the background passed in as parameters
   * and are assigned to the instance variables.
   *
   * @param levelNum An int which represents the level number of the GameLevel.
   * @param timeLimit A double which represents the time limit the user has to complete the level.
   * @param background A BufferedImage which visually represents the background onto the screen.
   */
  
  public GameLevel (int levelNum, double timeLimit, BufferedImage background)
  {
    this.levelNum = levelNum;
    this.timeLimit = timeLimit;
    this.background = background;
  }
}
