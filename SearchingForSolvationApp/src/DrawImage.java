import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawImage extends JPanel{
  
  public void displaySplashScreen (){
    JLabel pic = new JLabel();
    pic.setIcon (Utilities.SPLASH);
    this.add (pic,0,0);
  }

  
  public DrawImage() {

  }
}