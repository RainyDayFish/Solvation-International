/* This class is used to instantiate various platforms within the game for the player to jump on. Some platforms may have different images as well as different text corresponding
 * to the image, so that the user can correctly jump to a certain platform.
 * 
 * @author Atharva Washimkar
 * @version 1 05.21.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>text</b> A String which stores the text contained by each platform used to ensure checking that the user jumped onto a certain platform.
 */

import java.awt.*;

public class Platform extends Entities
{
  private String text;
  
    /* Description of getText ()
     * This method returns the String used to represent the text contained by each platform.
     *
     * @return A String that represents the text contained by each platform.
     */
    
  public String getText ()
  {
    return text;
  }
  
    /* Description of setText ()
     * This method sets the text of the platform based on the String parameter passed.
     *
     * @param newText A String that represents the text to be contained by a platform.
     */
    
  public void setText (String newText)
  {
    text = newText;
  }
  
    /*
     * This contructor creates a new PLatform object with it's coordinates on the screen, as well as the text, through passed parameters.
     *
     * @param x An int representing the platform's x location on the screen.
     * @param y An int representing the platform's y location on the screen.
     * @param text A String representing the text contained by a platform, used for checking if a user has landed on a certain platform.
     */
  
  public Platform (int x, int y, String text)
  {
    super (x, y);
    this.text = text;
  }
  
    /*
     * This contructor creates a new PLatform object with it's coordinates on the screen, an image to represent the Platform, as well as the text, through passed parameters.
     *
     * @param x An int representing the platform's x location on the screen.
     * @param y An int representing the platform's y location on the screen.
     * @param text A String representing the text contained by a platform, used for checking if a user has landed on a certain platform.
     * @param image A BufferedImage which is used to represent the Platform object visually on the screen.
     */
    
  public Platform (int x, int y, String text, BufferedImage image)
  {
    super (x, y, image);
    this.text = text;
  }
}
