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
  private int speed = 30;
  private int speedX=0;
  static final int DEFAULT_LIVES = 30;
  
  private Score score;
  private boolean isTangible;
  private double increment;
  private int lives = DEFAULT_LIVES;
  
  /* Description of getTangibility ()
   * A method which returns whether or not the Player's character is tangible within the game
   * 
   * @return A boolean value representing whether or not the Player's character is tangible.
   */
  
  public boolean getTangibility ()
  {
    return isTangible;
  }
  
  /* Description of setTangibility ()
   * A method which accepts a boolean parameter which changes the tangibility of the Player's character.
   * 
   * @param newTangibility A boolean value which represents the new value of isTangible.
   */
  
  public void setTangibility (boolean newTangibility)
  {
    isTangible = newTangibility;
  }
  
  /* Description of getIncrement ()
   * A method which returns the double value representing the speed increment.
   *
   * @return The double value representing the speed increment.
   */
  public void setSpeed(int speed){
  this.speed=speed;
  }
    public void setSpeedX(int speed){
  this.speedX=speed;
  }
    
    public int getSpeedX(){
    return speedX;
    }
  public int getSpeed(){
  return speed;
  }
  public double getIncrement ()
  {
    return increment;
  }
  
  /* Description of setIncrement ()
   * A method which allows the speed increment to be set to the value of a double parameter passed into the method.
   * 
   * @param newIncrement A double value which represents the new value of the speed increment.
   */
  
  public void setIncrement (double newIncrement)
  {
    increment = newIncrement;
  }
  
  /* Description of incrementSpeed ()
   * A method which increments the existing increment speed value by a double value passed into the method.
   *
   * @param addSpeed A double value which is added to the original increment speed to update/increment the old speed value.
   */
  
  public void incrementSpeed (double addSpeed){
    increment += addSpeed;
  }
  
  /* Description of getScore ()
   * A method which returns the Score object representing the player's score during the game.
   *
   * @return The Score object representing the player's score during the game.
   */
  
  public Score getScore (){
    return score;
  }
  
  /* Description of setScore ()
   * A method which sets the player's score to the Score object passed into the method.
   * 
   * @param newIncrement A Score object which represents the player's new score.
   */
  
  public void setScore (Score newScore){
    score = newScore;
  }
  
  /* Description of getLives ()
   * A method which returns the int value representing the amount of lives the player has left.
   *
   * @return The int value representing the amount of lives the player has left.
   */
  
  public int getLives (){
    return lives;
  }
  
  /* Description of setLives ()
   * A method which sets the player's amount of lives to the new int amount passed into the method.
   * 
   * @param newIncrement An int which represents the player's new amount of lives.
   */
  
  public void setLives (int newLives){
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
   * @param increment A double value which represents the additional speed on top of the existing basic speed of all the characters.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite, double increment)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = increment;
  }
  
  /*
   * The constructor creates a new instance of the Player class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Player object. The speed increment is set to 0.
   *
   * @param x An int value representing the x position of the Player within the game.
   * @param y An int value representing the y position of the Player within the game.
   * @param isTangible A boolean value which determines whether or not the Player object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = 0;
  }
  
  /*
   * The constructor creates a new instance of the Player class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Player object. The speed increment is set to 0.
   *
   * @param x An int value representing the x position of the Player within the game.
   * @param y An int value representing the y position of the Player within the game.
   * @param isTangible A boolean value which determines whether or not the Player object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   * @param lives An int which represents the amount of lives the player has.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite, int lives)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = 0;
    this.lives = lives;
  }
  
  /*
   * The constructor creates a new instance of the Player class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Player object.
   *
   * @param x An int value representing the x position of the Player within the game.
   * @param y An int value representing the y position of the Player within the game.
   * @param isTangible A boolean value which determines whether or not the Player object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   * @param increment A double value which represents the additional speed on top of the existing basic speed of all the characters.
   * @param lives An int which represents the amount of lives the player has.
   */
  
  public Player (int x, int y, boolean isTangible, BufferedImage sprite, double increment, int lives)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = increment;
    this.lives = lives;
  }
}
