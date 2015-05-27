import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class CoverFlowMenuItem {
  private BufferedImage image;
  private String name;
  private boolean isSelectable;
  private int x, y;
  
  public BufferedImage getImage (){
    return image;
  }
  
  public String getName (){
    return name;
  }
  
  public int getX (){
    return x;
  }
  
  public int getY () {
    return y;
  }
  
  public boolean getIsSelectable () {
    return isSelectable;
  }
  
  public void setImage (BufferedImage newImage){
    image = newImage;
  }
  
  public void setName (String newName){
    name = newName;
  }
  
  public void setX (int newX){
    x = newX;
  }
  
  public void setY (int newY){
    y = newY;
  }
  
  public void setIsSelectable (boolean newIsSelectable){
    isSelectable = newIsSelectable;
  }
  
  public CoverFlowMenuItem (String fileName, String name, boolean isSelectable) { 
    this.name = name;
    this.isSelectable = isSelectable;
    
    try{
      image = ImageIO.read (new File (fileName));
    }
    catch (IOException e){
    }
  }
}