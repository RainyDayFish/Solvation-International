import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
public final class Game {
  
  static Player player;
  static World world;
  static GameLevel currentLevel;
  static int time;
  static int questionNum = 0;
  static JFrame f = new JFrame("Game");
  public static Player getPlayer (){
    return player;
  }
  
  public static GameLevel getLevel(){
    return currentLevel;
  }
  
  public static void setPlayer (Player newPlayer){
    player = newPlayer;
  }
  
  public static void setLevel(GameLevel newLevel){
    currentLevel = newLevel;
  }
  
  public static void pauseGame(){
    
  }
  
  public static int landedWhere (){
    int counter = 0;
    if(player.getSpeed()<0){
    return -1;
    }
    for(Platform a : currentLevel.getPlatforms ()) {
      
      if(player.getX () >= a.getX ()-100 && player.getX () <= a.getX () + 250 && player.getY () > a.getY ()&&player.getY () < a.getY ()+20) {
        return counter;
      }
      counter++;
    }
    return -1;
  }
  
  public static boolean correctLanded(){
    if (landedWhere()!=-1&&currentLevel.getPlatforms(). get(landedWhere()).getText().equals(currentLevel.getQuestions().get(questionNum))){
      return true;
    }
    return false;
  }
  public static World getWorld(){
    return world;
  }
  public static void main(String args[]){
    Game g=new Game();
    try{
      BufferedImage character=ImageIO.read(new File("dot.png"));
      BufferedImage back1=ImageIO.read(new File("Clouds.png"));
      List<GameLevel> levels=new ArrayList<GameLevel>();
      levels.add(new GameLevel(1, 5000, back1));
      g=new Game(new Player(250, 0, true, character , 3), new World(1,  levels));
      //   for(Platform a:Game.getLevel().getPlatforms()){
      // System.out.println(a.getX());
      //  }
      g.drawGame();
      g.inGame();
    }catch(IOException e){
      
    }
    
  }
  public static void drawGame(){
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new Draw());
    f.pack();
    f.setVisible(true);
  }
  
  public static void inGame(){
    time=(int)currentLevel.getTimeLimit();
    while(/*player.getLives()>0*/ true){
      time--;
      player.setY(player.getY()+player.getSpeed());
      if(landedWhere()>-1){
        
        if(player.getY()<250){
          platShift();
        }else {
          player.setSpeed(player.getSpeed()*-1);
          System.out.println("Landed!!!!: "+player.getSpeed()+" "+landedWhere());
        }
      }else{
        if(player.getY()>=currentLevel.getLowest()+50){
          player.setLives(player.getLives()-1);
          player.setY(250);
         // player.setX(currentLevel.getLowest());
          player.setSpeed(50);
        }
      }
//      if(correctLanded()){
//        time=(int)currentLevel.getTimeLimit();
//      }else{
//        if (time<1){
//          player.setLives(player.getLives()-1);
//          time=(int)currentLevel.getTimeLimit();
//        }
//      }
      
      player.setSpeed(player.getSpeed()+5);
      currentLevel.cleanPlatform();
      f.getContentPane().validate();
      f.getContentPane().repaint();
      try {
        Thread.sleep(100);
      } catch (Exception e) {
        System.out.println(e);
      }
      
    }
    
  }
  
  public static void platShift(){
    while(player.getSpeed()>0){
      for(Platform a:currentLevel.getPlatforms()){
        a.setY(a.getY()+player.getSpeed());
      }
      player.setSpeed(player.getSpeed()-2);
    }
  }
  public  Game (Player player, World world) {
    this.player = player;
    this.world = world;
    currentLevel= world.getLevels().get(0);
  }
  public Game (Player player, World world,int l) {
    this.player = player;
    this.world = world;
    this.currentLevel=world.getLevels().get(l);
  }
  public Game(){
    
  }
}
