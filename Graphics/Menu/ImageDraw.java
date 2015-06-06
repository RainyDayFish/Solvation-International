import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ImageDraw extends JPanel{
public void paintComponent (Graphics g) {
    JLabel pic=new JLabel();
    pic.setIcon(Utilities.SPLASH);
g.drawImage(pic,0,0,this);
  }

}