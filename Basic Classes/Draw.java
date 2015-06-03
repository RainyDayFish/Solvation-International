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

public class Draw extends JPanel implements KeyListener{
  
  public Draw() {
    setBorder (BorderFactory.createLineBorder (Color.BLACK));
    addKeyListener (this);
  }
  
  public Dimension getPreferredSize() {
    return new Dimension (Utilities.SCREEN_SIZE, Utilities.SCREEN_SIZE); ////////////////////////////////////////WHY IS THIS + 50 ////////////////////////////////////////////////////////////////////////////
  }
  
  public void paintComponent (Graphics g){
    super.paintComponent (g);       
    //SearchingForSolvationFrame.game.getWorld();
    g.setFont (new Font ("Arial", Font.BOLD, 12));
    g.drawImage (SearchingForSolvationFrame.game.getWorld ().getLevel (SearchingForSolvationFrame.game.getCurrentLevel ()).getBackground (), 0, 0, this);
    g.drawImage (SearchingForSolvationFrame.game.getPlayer ().getImage (), SearchingForSolvationFrame.game.getPlayer().getX(), SearchingForSolvationFrame.game.getPlayer ().getY (), this);
    
    GameLevel level = SearchingForSolvationFrame.game.getWorld ().getLevel (SearchingForSolvationFrame.game.getCurrentLevel ());
    List <Platform> list = level.getPlatforms ();
    
    //for(Platform a : list){
    for (int i = 0; i < list.size (); i++){
      Platform a = list.get (i);
      g.drawImage(a.getImage (), a.getX (), a.getY (), this);
      // System.out.println(getX());
    }
    
    if(SearchingForSolvationFrame.game.landedWhere() > -1){
      g.drawString("" + SearchingForSolvationFrame.game.landedWhere (), list.get (SearchingForSolvationFrame.game.landedWhere ()).getX (), list.get (SearchingForSolvationFrame.game.landedWhere ()).getY ());
    }
    
    for (int i = 0; i < list.size (); i++){
      Platform a = list.get (i);
      g.drawString (a.getText (), a.getX (), a.getY ());
    }
    
    g.setColor (Color.WHITE);
    g.fillRect(0, Utilities.SCREEN_SIZE, Utilities.SCREEN_SIZE, Utilities.SCREEN_SIZE); //////// LAST PARAMETER USED TO BE 800, CHANGED TO 750 WHICH IS THE SCREEN SIZE
    
    g.setColor (Color.BLACK);
    g.setFont (new Font ("Arial", Font.PLAIN, 12));
    
    Question q = level.getQuestions ().get (SearchingForSolvationFrame.game.getQuestionNum ());
    
    //g.drawString(q.getQuestion () + " " + q.getAnswer (), 10, 770);
    
    if (SearchingForSolvationFrame.game.getTimeLeft () != -1){
      g.drawString (q.getQuestion () + " Answer: " + q.getAnswer (), 10, 770);
    }
    else {
      g.drawString (q.getQuestion () + " " + q.getAnswer (), 10, 770);
    }
    showLives (g);
  }
  
  private void showLives(Graphics g){
    for(int f = 0; f < SearchingForSolvationFrame.game.getPlayer ().getLives () - 1; f++){
      g.drawImage(Utilities.HEART_ICON, f * 35, 0, this);
    }
    if(SearchingForSolvationFrame.game.getTimeLeft () > 100 || ((SearchingForSolvationFrame.game.getTimeLeft () / 5) % 2 == 0)){
      g.drawImage (Utilities.HEART_ICON, (SearchingForSolvationFrame.game.getPlayer ().getLives () - 1) * 35, 0, this);
    }
  }
  
  public void addNotify () {
    super.addNotify ();
    requestFocus ();
  }
  
  private void setD(KeyEvent e){
    if((int)(e.getKeyCode ()) == KeyEvent.VK_KP_LEFT || (e.getKeyCode ()) == KeyEvent.VK_LEFT || e.getKeyChar () == 'a'){
      SearchingForSolvationFrame.game.getPlayer ().setSpeedX (-40);
      if( SearchingForSolvationFrame.game.getPlayer ().getSpeed () == 0 && SearchingForSolvationFrame.game.landedWhere () > -1){
        SearchingForSolvationFrame.game.getPlayer ().setSpeed (-50);
      }
    }
    else{
      if((int)(e.getKeyCode ()) == KeyEvent.VK_KP_RIGHT || (e.getKeyCode ()) == KeyEvent.VK_RIGHT || e.getKeyChar () == 'd'){
        SearchingForSolvationFrame.game.getPlayer ().setSpeedX (40);
        if( SearchingForSolvationFrame.game.getPlayer ().getSpeed () == 0 && SearchingForSolvationFrame.game.landedWhere () != -1){
          SearchingForSolvationFrame.game.getPlayer ().setSpeed (-50);
        }
      }
    }
  }
  
  public void keyTyped (KeyEvent e) {
    System.out.println ("KEY Released: " + e.getKeyChar ());
    setD (e);
    if((int)(e.getKeyCode ()) == KeyEvent.VK_KP_DOWN || (e.getKeyCode ()) == KeyEvent.VK_DOWN || e.getKeyChar () == 's'){
      //if(SearchingForSolvationFrame.game.landedWhere () > -1){
      //SearchingForSolvationFrame.game.getPlayer ().setSpeed (SearchingForSolvationFrame.game.getPlayer ().getSpeed () / 4);
      //}
      SearchingForSolvationFrame.game.getPlayer ().setTangibility (false);
    }
  }
  
  /** Handle the key-pressed event from the text field. */
  public void keyPressed (KeyEvent e){ 
    setD (e);
    
    if ((int)(e.getKeyCode ()) == KeyEvent.VK_KP_DOWN || (e.getKeyCode ()) == KeyEvent.VK_DOWN){
      // if(SearchingForSolvationFrame.game.landedWhere()>-1){
      //    SearchingForSolvationFrame.game.getPlayer().setSpeed(SearchingForSolvationFrame.game.getPlayer().getSpeed()/4);
      //  }
      SearchingForSolvationFrame.game.getPlayer ().setTangibility (false);
    }
  }
  
  /** Handle the key-released event from the text field. */
  public void keyReleased(KeyEvent e) {
    if((int)(e.getKeyCode())== KeyEvent.VK_KP_DOWN || (e.getKeyCode())== KeyEvent.VK_DOWN || e.getKeyChar () == 's'){
//      if(Game.landedWhere()>-1){
//        Game.getPlayer().setSpeed(Game.getPlayer().getSpeed()/4);
//      }
      SearchingForSolvationFrame.game.getPlayer ().setTangibility (true);
    }
  }
}