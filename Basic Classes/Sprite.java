import java.awt.*;

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
   * @param A boolean value which represents the new value of isTangible.
   */
  
  public void setTangibility (boolean newTangibility)
  {
    isTangible = newTangibility;
  }
  
  
  public double getIncrement ()
  {
    return increment;
  }
  
  
  public void setIncrement (double newIncrement)
  {
    increment = newIncrement;
  }
  
  public void incrementSpeed (double addSpeed){
    increment += addSpeed;
  }
  
  public Sprite (int x, int y, boolean isTangible, BufferedImage sprite, double increment)
  {
    super (x, y, sprite);
    this.isTangible = isTangible;
    this.increment = increment;
  }
}