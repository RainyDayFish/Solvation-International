import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Font;

import java.awt.image.BufferedImage;
public class Draw  extends JPanel implements KeyListener{
  public Draw() {
    setBorder(BorderFactory.createLineBorder(Color.black));
    addKeyListener(this);
  }
  
  public Dimension getPreferredSize() {
    return new Dimension(750,800);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);       
    Game.getWorld();
    g.setFont (new Font ("Arial", Font.BOLD, 12));
    g.drawImage(Game.getLevel().getBackground (),0,0,this);
    g.drawImage(Game.getPlayer().getImage(), Game.getPlayer().getX(), Game.getPlayer().getY(), this);
    List<Platform> list=Game.getLevel().getThreadSafePlatforms();
    // Game.getPlayer().setTan(true);
    for(int a=0;a<list.size();a++){
      g.drawImage(list.get(a).getImage(), list.get(a).getX(), list.get(a).getY(), this);
      
      // System.out.println(getX());
    }
    
    if(Game.landedWhere()>-1){
      g.drawString(""+Game.landedWhere(),Game.getLevel().getPlatforms().get(Game.landedWhere()).getX(),Game.getLevel().getPlatforms().get(Game.landedWhere()).getY());
    }
    //  g.drawString("This works!",10,20);
    
    for(int f=0;f<Game.getLevel().getPlatforms().size();f++ ){
      Platform a=Game.getLevel().getPlatforms().get(f);
      g.drawString(a.getText(),a.getX(),a.getY());
    }
    g.setColor (Color.WHITE);
    g.fillRect(0,750 , 750, 800);
    g.setColor (Color.BLACK);
    g.setFont (new Font ("Arial", Font.PLAIN, 12));
    Question q=Game.getLevel().getQuestions().get(Game.getQuestionNum());
    
    if(Game.getTimeLeft()<1){
      g.drawString(q.getQuestion()+" Answer: "+q.getAnswer(),10,770);
    }else{
      g.drawString(q.getQuestion()+" "+q.getAnswer(),10,770);
    }
    showLives(g);
  }
  private void showLives(Graphics g){
    try{
      BufferedImage pic=ImageIO.read(new File("Heart.png"));
      for(int f=0;f<Game.getPlayer().getLives()-1;f++){
        g.drawImage(pic,f*35,0, this);
      }
      if(Game.getTimeLeft()>100||((Game.getTimeLeft()/5)%2==0)){
        g.drawImage(pic,(Game.getPlayer().getLives()-1)*35,0, this);
      }
      
    }catch(IOException e){
      
    }
  }
  
  
  public void addNotify() {
    super.addNotify();
    requestFocus();
  }
  private void setD(KeyEvent e){
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_LEFT || (e.getKeyCode())== KeyEvent.VK_LEFT||e.getKeyChar()=='a'){
      Game.getPlayer().setSpeedX(-40);
      if( Game.getPlayer().getSpeed()==0&&Game.landedWhere()>-1){
        Game.getPlayer().setSpeed(-50);
      }
    }
    else{
      if((int)(e.getKeyCode())== KeyEvent.VK_KP_RIGHT || (e.getKeyCode())== KeyEvent.VK_RIGHT||e.getKeyChar()=='d'){
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
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_DOWN || (e.getKeyCode())== KeyEvent.VK_DOWN||e.getKeyChar()=='s'){
//      if(Game.landedWhere()>-1){
//        Game.getPlayer().setSpeed(Game.getPlayer().getSpeed()/4);
//      }
      Game.getPlayer().setTan(false);
    }
  }
  
  
  /** Handle the key-pressed event from the text field. */
  public void keyPressed(KeyEvent e) {
    
    setD(e);
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_DOWN || (e.getKeyCode())== KeyEvent.VK_DOWN){
//      if(Game.landedWhere()>-1){
//        Game.getPlayer().setSpeed(Game.getPlayer().getSpeed()/4);
//      }
      Game.getPlayer().setTan(false);
    }
  }
  
  /** Handle the key-released event from the text field. */
  public void keyReleased(KeyEvent e) {
    
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_DOWN || (e.getKeyCode())== KeyEvent.VK_DOWN||e.getKeyChar()=='s'){
//      if(Game.landedWhere()>-1){
//        Game.getPlayer().setSpeed(Game.getPlayer().getSpeed()/4);
//      }
      Game.getPlayer().setTan(true);
    }
    // System.out.println( "KEY Released: "+e.getKeyChar());
  }
}
