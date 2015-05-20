import java.awt.*;

public abstract class Entities
{
  private int x, y;
  private BufferedImage image;
  
  public int getX ()
  {
    return x;
  }
  
  
  public int getY ()
  {
    return y;
  }
  
  
  public BufferedImage getImage ()
  {
    return image;
  }
  
  
  public void setX (int newX)
  {
    x = newX;
  }
  
  
  public void setY (int newY)
  {
    y = newY;
  }
  
  
  public void setImage (BufferedImage newImage)
  {
    image = newImage;
  }
  
  
  public Entities (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  
  public Entities (int x, int y, BufferedImage image)
  {
    this.x = x;
    this.y = y;
    this.image = image;
  }
}
