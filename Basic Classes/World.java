import java.util.*;
import java.awt.image.BufferedImage;

/* This class is instantiated to create the various worlds in which the user plays the game within. The difficulty level of the levels
 * within the world varies based on the difficulty level of the world.
 * 
 * @author Atharva Washimkar
 * @version 1 05.20.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>difficulty</b> Stores an int value which represents the difficulty of the world.
 //* <p>
 //* <b>background</b> Stores a BufferedImage which is the background image to be used for the world.
 * <p>
 * <b>levels</b> Stores a List of GameLevels which are within the particular world, and are accessible to be played.
 */

public abstract class World
{
  private int difficulty;
  // private BufferedImage background;
  private List < GameLevel > levels;
  
  /* Description of getDifficultyLevel ()
   * A method which returns the difficulty level of a particular world.
   * 
   * @return the difficulty level of the world
   */
  
  public int getDifficultyLevel ()
  {
    return difficulty;
  }
  
  /* Description of getLevel ()
   * A method which returns a particular GameLevel object contained within the world.
   * 
   * @param levelNum An int specifying which level to return
   * @return a GameLevel object at the specified index
   */
  
  public GameLevel getLevel (int levelNum)
  {
    return levels.get (levelNum);
  }
  
//  /* Description of getBackground ()
  //  * A method which returns a BufferedImage which represents the world background.
//   * 
//   * @return A BufferedImage object representing the background.
  //  */
  
//  public BufferedImage getBackground ()
// {
  //  return background;
//  }
  
  /* Description of getLevels ()
   * A method which returns a List of GameLevel objects which represents the various levels within a particular world.
   * 
   * @return A List containing the various levels within the world.
   */
  
  public List < GameLevel > getLevels ()
  {
    return levels;
  }
  
  /*
   *The class constructor is responsible for creating a world object as well as its various properties, e.g.
   * difficulty, background image and the levels within the game.
   * 
   * It also creates the platforms to be used within each level of the world.
   * 
   * @param difficulty An int value specifying the difficulty of the world's level.
   //* @param background A BufferedImage representing the background image used by the world.
   * @param levels <GameLevel> A List of GameLevels which represents the various levels within the game.
   */
  
  public World (int difficulty,  List < GameLevel > levels
//  BufferedImage background
               )
  {
    this.difficulty = difficulty;
    // this.background = background;
    this.levels = levels;
    
    for (GameLevel i : levels){
      i.generatePlatforms (this.difficulty);
    }
  }
}
