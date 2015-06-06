import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawImage extends JPanel{

  
public DrawImage() {
JLabel pic=new JLabel();
this.add(pic,0,0);
    pic.setIcon(Utilities.SPLASH);
     

//JLabel img = new JLabel();
//    f.add(img); 
    //img.setIcon(new ImageIcon(this.getClass().getResource("/assets/splash-screen.gif")));
}

}