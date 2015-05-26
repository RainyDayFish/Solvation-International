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
    for(Platform a : world.getLevel (currentLevel.getLevelNum()-1).getPlatforms ()) {
      
      if(player.getX () >= a.getX () && player.getX () <= a.getX () + 30 && player.getY () == a.getY ()) {
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
      g=new Game(new Player(0, 0, true, character , 3), new World(1,  levels));
   //   for(Platform a:Game.getLevel().getPlatforms()){
    // System.out.println(a.getX());
    //  }d
      g.drawGame();
    g.inGame();
    }catch(IOException e){
    
    }
    
  }
  public static void drawGame(){
    JFrame f = new JFrame("Game");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new Draw());
    f.pack();
    f.setVisible(true);
  }
  
  public static void inGame(){
    time=(int)currentLevel.getTimeLimit();
    while(player.getLives()>0){
      time--;
      player.setY(player.getY()+player.getSpeed());
      if(landedWhere()>-1){
        
        if(player.getY()<250){
          platShift();
        }else {
          player.setSpeed(player.getSpeed()*-1);
        }
      }else{
        if(player.getY()<=currentLevel.getLowest()+50){
          player.setLives(player.getLives()-1);
          player.setY(currentLevel.getLowest());
          player.setSpeed(10);
        }
      }
      if(correctLanded()){
        time=(int)currentLevel.getTimeLimit();
      }else{
        if (time<1){
          player.setLives(player.getLives());
          time=(int)currentLevel.getTimeLimit();
        }
      }
 
      player.setSpeed(player.getSpeed()+2);
      currentLevel.cleanPlatform();
     try {
   Thread.sleep(500);
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
