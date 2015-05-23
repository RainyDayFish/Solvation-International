import java.awt.image.BufferedImage;

/* This abstract class is used to specify various common attributes and methods 
 * for various objects within the game, e.g. Sprites and Platforms.
 * 
 * @author Atharva Washimkar
 * @version 1 05.22.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>x</b> An int which specifies the x location of an Entity object on the screen.
 * <p>
 * <b>y</b> An int which specifies the y location of an Entity object on the screen.
 * <p>
 * <b>image</b> A BufferedImage which is used to visually represent the Entity on the screen.
 */

public abstract class Entities
{
  private int x, y;
  private BufferedImage image;
  
  /* Description of getX ()
   * This method is used to return the x position of an Entity on a screen.
   *
   * @return The int which represents the x position of an Entity on the screen.
   */
  
  public int getX ()
  {
    return x;
  }
  
  /* Description of getY ()
   * This method is used to return the y position of an Entity on a screen.
   *
   * @return The int which represents the y position of an Entity on the screen.
   */
  
  public int getY ()
  {
    return y;
  }
  
  /* Description of getImage ()
   * This method is used to return the image used to visually represent the Entity on the screen.
   *
   * @return The BufferedImage which visually represents an Entity on the screen.
   */
  
  public BufferedImage getImage ()
  {
    return image;
  }
  
  /* Description of setX ()
   * This method sets a new x position of an Entity on a screen by passing a new int into the method.
   *
   * @param newX An int representing the new x position of an Entity on the screen.
   */
  
  public void setX (int newX)
  {
    x = newX;
  }
  
  /* Description of setY ()
   * This method sets a new y position of an Entity on a screen by passing a new int into the method.
   *
   * @param newY An int representing the new y position of an Entity on the screen.
   */
  
  public void setY (int newY)
  {
    y = newY;
  }
  
  /* Description of setImage ()
   * This method sets a new image to represent an Entity on a screen by passing a new BufferedImage into the method.
   *
   * @param newImage A BufferedImage representing the Entity visually onto the screen.
   */
  
  public void setImage (BufferedImage newImage)
  {
    image = newImage;
  }
  
  /*
   * This constructor is not used to instantiate an Entities object, rather to assign values to the x and y values of an object which extends Entities.
   *
   * @param x An int value which is assigned to the instance variable x.
   * @param y An int value which is assigned to the instance variable y.
   */
  
  public Entities (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  /*
   * This constructor is not used to instantiate an Entities object, rather to assign values to the x, y and image values of an object which extends Entities.
   *
   * @param x An int value which is assigned to the instance variable x, setting an x location of the object.
   * @param y An int value which is assigned to the instance variable y, settting a y location of the object.
   * @param image A BufferedImage which is assigned to the instance variable image, setting a visual representation for the object.
   */
  
  public Entities (int x, int y, BufferedImage image)
  {
    this.x = x;
    this.y = y;
    this.image = image;
  }
}
