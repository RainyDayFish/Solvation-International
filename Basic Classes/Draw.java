import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
public class Draw  extends JPanel implements KeyListener{
  public Draw() {
    setBorder(BorderFactory.createLineBorder(Color.black));
     addKeyListener(this);
  }
  
  public Dimension getPreferredSize() {
    return new Dimension(750,750);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);       
    Game.getWorld();
    g.drawImage(Game.getLevel().getBackground (),0,0,this);
    g.drawImage(Game.getPlayer().getImage(), Game.getPlayer().getX(), Game.getPlayer().getY(), this);
    for(Platform a:Game.getLevel().getPlatforms()){
      g.drawImage(a.getImage(), a.getX(), a.getY(), this);
      
      // System.out.println(getX());
    }
    if(Game.landedWhere()>-1){
      g.drawString(""+Game.landedWhere(),Game.getLevel().getPlatforms().get(Game.landedWhere()).getX(),Game.getLevel().getPlatforms().get(Game.landedWhere()).getY());
    }
    //  g.drawString("This works!",10,20);
  }
  public void addNotify() {
    super.addNotify();
    requestFocus();
  }
  private void setD(KeyEvent e){
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_LEFT || (e.getKeyCode())== KeyEvent.VK_LEFT){
    Game.getPlayer().setSpeedX(-40);
    if( Game.getPlayer().getSpeed()==0&&Game.landedWhere()>-1){
    Game.getPlayer().setSpeed(-50);
    }
    }else{
      if((int)(e.getKeyCode())== KeyEvent.VK_KP_RIGHT || (e.getKeyCode())== KeyEvent.VK_RIGHT){
       Game.getPlayer().setSpeedX(40);
       if( Game.getPlayer().getSpeed()==0&&Game.landedWhere()>-1){
       Game.getPlayer().setSpeed(-50);
       }
      }
  }
  }
  public void keyTyped(KeyEvent e) {
     System.out.println( "KEY Released: "+e.getKeyChar());
  setD(e);
    }

  
  /** Handle the key-pressed event from the text field. */
  public void keyPressed(KeyEvent e) {
    
   setD(e);
  }
  
  /** Handle the key-released event from the text field. */
  public void keyReleased(KeyEvent e) {
   // System.out.println( "KEY Released: "+e.getKeyChar());
  }
}
