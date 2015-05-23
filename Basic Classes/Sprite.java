import java.awt.image.BufferedImage;

/*
 * The Sprite class extends Entities, and is used to create the characters that the player will use to play the game.
 * The characters may have various properties, e.g. higher speed, tangibility, etc.
 * 
 * @author Atharva Washimkar
 * @version 1 05.20.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>MOVEMENT_SPEED</b> A static final double value which sets the default movement speed of all Sprite objects
 * <p>
 * <b>isTangible</b> A boolean variable which determined whether or not the Sprite object is tangible.
 * <p>
 * <b>increment</b> A double value which represents the additional speed gained by the Sprite on top of the existing speed.
 */

public class Sprite extends Entities
{
  static final double MOVEMENT_SPEED = 0.95;
  private boolean isTangible;
  private double increment;
  
  /* Description of getTangibility ()
   * A method which returns whether or not the Sprite object is tangible
   * 
   * @return A boolean value representing whether or not the Sprite object is tangible.
   */
  
  public boolean getTangibility ()
  {
    return isTangible;
  }
  
  /* Description of setTangibility ()
   * A method which accepts a boolean parameter which changes the tangibility of the Sprite object.
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
  
  /*
   * The constructor creates a new instance of the Sprite class with various attributes which are passed into the constructor. The values passed
   * into the constructor are used as the attributes of the new Sprite object.
   *
   * @param x An int value representing the x position of the Sprite within the game.
   * @param y An int value representing the y position of the Sprite within the game.
   * @param isTangible A boolean value which determines whether or not the Sprite object can go through walls or not, i.e. is "tangible"
   * @param sprite A BufferedImage which is the visual representation of the sprite, or a picture of the sprite.
   * @param increment A double value which represents the additional speed on top of the existing basic speed of all the characters.
   */
  
  public Sprite (int x, int y, boolean isTangible, BufferedImage sprite, double increment)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = increment;
  }
}