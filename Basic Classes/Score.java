/* This class is used to store the progress of the player in terms of their game score. The Score compares many items, e.g. names, difficulties, etc.
 * 
 * @author Atharva Washimkar
 * @version 1 05.21.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>difficulty</b> Stores an int value which represents the difficulty of the world played.
 * <p>
 * <b>name</b> Stores a String which stores the name of the player who achieved the goal.
 * <p>
 * <b>score</b> An int value representing their score, which depends on the player's progress through the game.
 */

public class Score
{
  private String name;
  private int difficulty, score;
  
  /* Description of getName ()
   * Returns the String representing the name of the user who has achieved the score represented by a Score object.
   *
   * @return A String representing the user's name.
   */
  
  public String getName ()
  {
    return name;
  }
  
  /* Description of getScore ()
   * This method returns an int representing the score of the user so far through the game.
   *
   * @return An int representing the score of the user as they progress through the game.
   */
  
  public int getScore ()
  {
    return score;
  }
  
  /* Description of getScore ()
   * This method returns an int representing the difficulty of the world being played by the user.
   *
   * @return An int representing the difficulty level of the world played.
   */
  
  
  public int getDifficulty ()
  {
    return difficulty;
  }
  
  /* Description of setName ()
   * This method sets a new value of the player's name based on the String parameter passed in.
   *
   * @param newName A String representing the new player name.
   */
  
  public void setName (String newName)
  {
    name = newName;
  }
  
  /* Description of setScore ()
   * This method sets a new value of the player's score based on the int parameter passed in.
   *
   * @param newScore An int representing the new player score.
   */
  
  public void setScore (int newScore)
  {
    score = newScore;
  }
  
  /* Description of setDifficulty ()
   * This method sets a new value of the difficulty level of the world played for the player based on the int
   * value passed into the method.
   *
   * @param newScore An int representing the new difficulty level.
   */
  
  
  public void setDifficulty (int newDifficulty)
  {
    difficulty = newDifficulty;
  }
  
  /*
   * The constructor creates a new Score object which has various attributes passed into the constructor as parameters, and are assigned to the instance variables of the new Score object.
   *
   * @param name A String value representing the name of the player achieving the score.
   * @param score An int value representing the actual score achieved by the player.
   * @param difficulty An int value representing the difficulty level of the world chosen by the player.
   * @param level An int value representing the level played by the player.
   */
  
  public Score (String name, int score, int difficulty)
  {
    this.name = name;
    this.score = score;
    this.difficulty = difficulty;
  }
}