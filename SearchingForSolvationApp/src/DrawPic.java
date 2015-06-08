import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class DrawPic extends JPanel implements MouseListener, KeyListener {
  
  boolean back=false, chose=false, addScores = false;
  BufferedImage b;
  int time;
  
  public void draw(Graphics g){
    g.drawImage(b,0,0,this);
    
    if (addScores){
      g.setColor (Color.WHITE);
      g.setFont (new Font ("Arial", Font.PLAIN, 20));
      g.drawString ("Name", 110, 175);
      g.drawString ("Difficulty", 255, 175);
      g.drawString ("Level", 425, 175);
      g.drawString ("Score", 560, 175);
      
      for (int i = 0; i < HighScore.highScores.size (); i++){
        Score x = HighScore.highScores.get (i);
        g.drawString ("#" + (i + 1) + " " + x.getName (), 110, 225 + i * 30);
        g.drawString (x.getDifficulty () == 0 ? "Easy" : x.getDifficulty () == 1 ? "Medium" : "Hard", 255, 225 + i * 30);
        g.drawString ("" + x.getLevel (), 425, 225 + i * 30);
        g.drawString ("" + x.getScore (), 560, 225 + i * 30);
      }
    }
    
    Utilities.refreshScreen ();
    //System.out.println("asdf");
    if(time>-1){
      try{
        //Thread.sleep(time);
        Utilities.delay (time);
      }catch(Exception e){
        
      }
    }
  }
  
  public void addScores (){
    addScores = true;
    repaint ();
  }
  
  public DrawPic(BufferedImage b,int time){
    this.b=b;
    this.time=time;
    this.setFocusable (true);
    addMouseListener (this);
    addKeyListener (this);
  }
  
  public void paintComponent (Graphics g) {
    if (!chose){
      draw (g);
    }
  }
  public void mouseExited (MouseEvent e){}
  
  public void mousePressed (MouseEvent e){
    if (e.getX () >= 306 && e.getX () <= 463&&e.getY()<674&&e.getY()>538){
      back=true;
      chose=true;
    }
    System.out.println(e.getX()+" "+e.getY());
    System.out.println("clicked");
  }
  public void mouseEntered (MouseEvent e){}
  
  public void mouseReleased (MouseEvent e){}
  
  public void mouseClicked (MouseEvent e){}
  
  public void getBack(){
    if(time>-1){
      for(int f=0;f<time;f++){
        
        /*try{
         Thread.sleep(1000);
         }catch(Exception e){
         
         }*/
        Utilities.delay (1000);
      }
      return ;
    }
    while (!chose){
      paintComponent (getGraphics ());
      //  System.out.println("got back");
    }
    return;
  }
  
  public void keyPressed (KeyEvent e){
    if (e.getKeyCode () == KeyEvent.VK_ENTER){
      chose=true;
      back=true;
    }
    System.out.println("Pressed");
  }
  
  public void keyTyped (KeyEvent e){}
  
  public void keyReleased (KeyEvent e){}
}