import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class DrawPic extends JPanel implements MouseListener {
boolean back=false, chose=false;
BufferedImage b;
int time;
  public void draw(Graphics g){
 

g.drawImage(b,0,0,this);
Utilities.refreshScreen ();
System.out.println("asdf");
if(time>-1){
try{
Thread.sleep(time);
}catch(Exception e){

}
}

  }
  public DrawPic(BufferedImage b,int time){
  this.b=b;
  this.time=time;
  this.setFocusable (true);
  addMouseListener (this);
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
   System.out.println("as;ldfjk");
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
        
          try{
          Thread.sleep(1000);
          }catch(Exception e){
          
          }
        }
        return ;
      }
          while (!chose){
      paintComponent (getGraphics ());
    //  System.out.println("got back");
    }
          
    return ;
    }
}