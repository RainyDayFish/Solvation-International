import java.awt.image.BufferedImage;

/*
 * The Player class extends Entities, and is used to create the characters that the player will use to play the game.
 * The characters may have various properties, e.g. higher speed, tangibility, etc.
 * 
 * @author Atharva Washimkar
 * @version 1 05.20.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>MOVEMENT_SPEED</b> A static final double value which sets the default movement speed of all Player objects.
 * <p>
 * <b>DEFAULT_LIVES</b> A static final int value which sets the default amount of lives the Player starts with.
 * <p>
 * <b>score</b> A Score object which represents the player's score during the game.
 * <p>
 * <b>isTangible</b> A boolean variable which determined whether or not the Player object is tangible.
 * <p>
 * <b>increment</b> A double value which represents the additional speed gained by the Player on top of the existing speed.
 * <p>
 * <b>lives</b> An int value which represents the amount of lives the player has left within the game.
 */

public class Player extends Entities
{
  private int speed = 30, speedX = 0, lives = DEFAULT_LIVES;
  static final int DEFAULT_LIVES = 10;
  private String name;
  private Score score;
  private boolean isTangible = true;
  
  /* Description of getTangibility ()
   * A method which returns whether or not the Player's character is tangible within the game
   * 
   * @return A boolean value representing whether or not the Player's character is tangible.
   */
  
  public boolean getTan ()
  {
    return isTangible;
  }
  public String getName(){
    return name;
  }
  
  public void setName(String a){
    name=a;
  }
  /* Description of setTangibility ()
   * A method which accepts a boolean parameter which changes the tangibility of the Player's character.
   * 
   * @param newTangibility A boolean value which represents the new value of isTangible.
   */
  
  public void setTan (boolean newTangibility)
  {
    isTangible = newTangibility;
  }
  
  public int getSpeed ()
  {
    return speed;
  }
  
  public void setSpeed (int speed)
  {
    this.speed = speed;
  }
  
  public int getSpeedX ()
  {
    return speedX;
  }
  
  public void setSpeedX (int speed)
  {
    this.speedX = speed;
  }
  
  /* Description of getScore ()
   * A method which returns the Score object representing the player's score during the game.
   *
   * @return The Score object representing the player's score during the game.
   */
  
  public Score getScore ()
  {
    return score;
  }
  
  /* Description of setScore ()
   * A method which sets the player's score to the Score object passed into the method.
   * 
   * @param newIncrement A Score object which represents the player's new score.
   */
  
  public void setScore (Score newScore)
  {
    score = newScore;
  }
  
  /* Description of getLives ()
   * A method which returns the int value representing the amount of lives the player has left.
   *
   * @return The int value representing the amount of lives the player has left.
   */
  
  public int getLives ()
  {
    return lives;
  }
  
  /* Description of setLives ()
   * A method which sets the player's amount of lives to the new int amount passed into the method.
   * 
   * @param newIncrement An int which represents the player's new amount of lives.
   */
  
  public void setLives (int newLives)
  {
    lives = newLives;
  }
  
  /*
   * The constructor creates a new instance of the Player class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Player object.
   *
   * @param x An int value representing the x position of the Player within the game.
   * @param y An int value representing the y position of the Player within the game.
   * @param isTangible A boolean value which determines whether or not the Player object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite,String name)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.name=name;
    score=new Score(name,0,1,1);
  }
  
  /*
   * The constructor creates a new instance of the Player class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Player object.
   *
   * @param x An int value representing the x position of the Player within the game.
   * @param y An int value representing the y position of the Player within the game.
   * @param isTangible A boolean value which determines whether or not the Player object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   * @param lives An int which represents the amount of lives the player has.
   * @param score A Score object representing the player's score in the game.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite, int lives, Score score,String name)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.lives = lives;
    this.score = score;
    this.name=name;
  }
}