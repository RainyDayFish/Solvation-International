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

public class Game  {
  
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
  public static int getQuestionNum(){
    return questionNum;
  }
  public static int landedWhere (){
    int counter = 0;
    if(player.getSpeed()<0){
      return -1;
    }
    for(Platform a : currentLevel.getPlatforms ()) {
      
      if(player.getX () >= a.getX ()-100 && player.getX () <= a.getX () + 100 && player.getY () > a.getY ()-100&&player.getY () < a.getY ()-20) {
        return counter;
      }
      counter++;
    }
    return -1;
  }
  
  public static boolean correctLanded(){
    if (landedWhere()!=-1&&currentLevel.getPlatforms(). get(landedWhere()).getText().equals(currentLevel.getQuestions().get(questionNum).getAnswer())){
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
      BufferedImage back2=ImageIO.read(new File("Hills.png"));
      BufferedImage back3=ImageIO.read(new File("Night One.png"));
      
//      List backgrounds=new arrayList <BufferedImage> ();
//      backgrounds.add(back1);
//      backgrounds.add(back2);
//      backgrounds.add(back3);
      
      List<GameLevel> levels=new ArrayList<GameLevel>();
      levels.add(new GameLevel(1, 500, back1));
      levels.add(new GameLevel(2, 500, back2));
      levels.add(new GameLevel(3, 500, back3));
      g=new Game(new Player(250, 0, true, character , 10), new World(1,  levels));
      //   for(Platform a:Game.getLevel().getPlatforms()){
      // System.out.println(a.getX());
      //  }
      g.drawGame();
      g.inGame();
      
    }catch(IOException e){
      System.out.println("I messed up");
    }
    
  }
  public static void drawGame(){
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new Draw());
    f.pack();
    f.setVisible(true);
  }
  public static int getTimeLeft(){
    return time;
  }
  public static void inGame(){
    time=(int)currentLevel.getTimeLimit();
    while(player.getLives()>0){
      time--;
      
      player.setY(player.getY()+player.getSpeed());
      if(player.getX()>750){
        player.setX(player.getSpeedX());
      }else if(player.getX()<-50){
        player.setX(player.getSpeedX()+750);
      }
      else{
        player.setX(player.getX()+player.getSpeedX());
      }
      //    System.out.println(landedWhere());
      if(landedWhere()>-1&&player.getTan()){
        
        if(player.getY()<300){
          platShift();
        }else {
          if(correctLanded()){
            System.out.println("correct");
            time=(int)currentLevel.getTimeLimit();
            questionNum++;
            if(questionNum>=currentLevel.getQuestions().size()){
              System.out.println("New World!");
              questionNum=0;
              if(currentLevel.getLevelNum()<world.getLevels().size()){
                setLevel(world.getLevel(currentLevel.getLevelNum()));
                f.getContentPane().validate();
                f.getContentPane().repaint();
                try {
                  Thread.sleep(1000);
                } catch (Exception e) {
                  System.out.println(e);
                }
                player.setLives(player.getLives()-1);
                player.setY(250);
                player.setX(currentLevel.getPlatforms().get(currentLevel.getLowestPlatform()).getX());
                player.setSpeed(25);
                try {
                  Thread.sleep(1000);
                } catch (Exception e) {
                  System.out.println(e);
                }
              }else{
                return;
              }
              
            }
            
          }
          //       System.out.println(landedWhere());
          if(landedWhere()>-1){
            System.out.println("Landed!!!!: "+player.getSpeed()+" "+landedWhere()+" "+currentLevel.getPlatforms().get(landedWhere()).getText()+" Lives: "+player.getLives());
            System.out.println(time);
          }
          //  player.setSpeed(player.getSpeed()*-1);
          player.setSpeed(-50);
          // player.setSpeed(-50);
        }
      }else{
        if(player.getY()>=currentLevel.getLowest()+200){
          player.setLives(player.getLives()-1);
          player.setY(250);
          player.setX(currentLevel.getPlatforms().get(currentLevel.getLowestPlatform()).getX());
          // player.setX(currentLevel.getLowest());
          player.setSpeed(25);
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
            System.out.println(e);
          }
        }
        
      }
      if (time<1){
        player.setLives(player.getLives()-1);
        f.getContentPane().validate();
        f.getContentPane().repaint();
        try {
          Thread.sleep(2000);
        } catch (Exception e) {
          System.out.println(e);
        }
        time=(int)currentLevel.getTimeLimit();
        questionNum++;
      }
      if(landedWhere()==-1||player.getSpeed()!=0){
        player.setSpeed(player.getSpeed()+5);
      }
      if(player.getSpeedX()-15>=0){
        player.setSpeedX(player.getSpeedX()-15);
      }else{
        player.setSpeedX(0);
      }
      currentLevel.cleanPlatform();
      f.getContentPane().validate();
      f.getContentPane().repaint();
      try {
        Thread.sleep(50);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
  
  public static void platShift(){
    player.setSpeed(-30);
    while(player.getSpeed()<0){
      currentLevel.cleanPlatform();
      for(int f=0;f<currentLevel.getPlatforms().size();f++){
        currentLevel.getPlatforms().get(f).setY(currentLevel.getPlatforms().get(f).getY()-player.getSpeed());
      }
      player.setSpeed(player.getSpeed()+5);
      //     f.getContentPane().validate();
      f.getContentPane().repaint();
      try {
        Thread.sleep(50);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    player.setSpeed(0);
    //   currentLevel.cleanPlatform();
  }
  public  Game (Player player, World world) {
    this.player = player;
    this.world = world;
    currentLevel= world.getLevel(0);
  }
  public Game (Player player, World world,int l) {
    this.player = player;
    this.world = world;
    this.currentLevel=world.getLevel(l);
  }
  public Game(){
    
  }
}
