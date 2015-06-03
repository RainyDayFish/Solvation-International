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
  
  private Player player;
  private World world;
  // private GameLevel currentLevel;
  private int timeLeft, questionNum = 0, currentLevel;
  //private JFrame f = new JFrame("Game");
  
  public Player getPlayer (){
    return player;
  }
  
  public World getWorld(){
    return world;
  }
  
  public int getTimeLeft (){
    return timeLeft;
  }
  
  public int getQuestionNum (){
    return questionNum;
  }
  
  public int getCurrentLevel (){
    return currentLevel;
  }
  
  public void setPlayer (Player newPlayer){
    player = newPlayer;
  }
  
  public void setWorld (World newWorld){
    world = newWorld;
  }
  
  public void setTimeLeft (int newTimeLeft){
    timeLeft = newTimeLeft;
  }
  
  public void setQuestionNum (int newQuestionNum){
    questionNum = newQuestionNum;
  }
  
  public void setCurrentLevel (int newCurrentLevel){
    currentLevel = newCurrentLevel;
  }
  
  /*public void pauseGame (){
   * 
   }*/
  
  public /*synchronized*/ int landedWhere (){
    int counter = 0;
    
    if(player.getSpeed () < 0){
      return -1;
    }
    
    for (Platform a : world.getLevel (currentLevel).getPlatforms ()){
      if (player.getX () >= a.getX () - 100 && player.getX () <= a.getX () + 100 && player.getY () > a.getY () - 100 && player.getY () < a.getY () - 20) {
        return counter;
      }
      counter++;
    }
    return -1;
  }
  
  public /*synchronized*/ boolean correctLanded (){
    if (landedWhere() != -1 && world.getLevel (currentLevel).getPlatforms ().get (landedWhere()).getText ().equals (world.getLevel (currentLevel).getQuestions ().get (questionNum).getAnswer ())){
      //timeLeft = world.getLevel (currentLevel).getTimeLimit ();
      //questionNum++;
      return true;
    }
    return false;
  }
  
  public void updatePlayerXPosition (){
    if (player.getX () > 750)
      player.setX (player.getSpeedX ());
    else if (player.getX () < -50)
      player.setX (player.getSpeedX () + 750);
    else
      player.setX (player.getX () + player.getSpeedX ());
  }
  
  public boolean hasWonLevel (){
    return questionNum >= world.getLevel (currentLevel).getQuestions ().size ();
  }
  
  public boolean updateLanding (){
    if (landedWhere () > -1 && player.getTangibility ()){
      if (player.getY () < 300){
        platformShift ();
      }
      else {
        if (correctLanded ()){
          System.out.println ("correct");
          
          timeLeft = world.getLevel (currentLevel).getTimeLimit ();
          questionNum++;
          
          if(hasWonLevel ()){
            return true;
          }
        }
        
        System.out.println ("Landed!!!!: " + player.getSpeed () + " " + landedWhere () + " " + world.getLevel (currentLevel).getPlatforms ().get (landedWhere ()).getText () + " Lives: " + player.getLives ());
        System.out.println (timeLeft);
        
        //player.setSpeed (player.getSpeed () * -1);
        player.setSpeed(-50);
      }
    }
    else{
      if(player.getY () >= world.getLevel (currentLevel).getLowest () + /*100*/200){
        player.setLives (player.getLives() - 1);
        player.setY (250);
        // player.setX(currentLevel.getLowest());
        player.setSpeed (25);
        
        Utilities.delay (1000);
      }
    }
    return false;
  }
  
  public void updatePlayerSpeed (){
    if(landedWhere () == -1 || player.getSpeed () != 0)
      player.setSpeed (player.getSpeed () + 5);
    
    if(player.getSpeedX () - 15 >= 0)
      player.setSpeedX (player.getSpeedX () - 15);
    else
      player.setSpeedX (0);
  }
  
  public void updateGameState (){
    timeLeft--;
    player.setY (player.getY () + player.getSpeed ());
    
    updatePlayerXPosition ();
    
    if (updateLanding ())
      return;
    
    if (timeLeft < 1){
      player.setLives (player.getLives () - 1);
      //timeLeft = world.getLevel (currentLevel).getTimeLimit ();
      Utilities.delay (2000);
      
      timeLeft = world.getLevel (currentLevel).getTimeLimit ();
      //questionNum++;                      /////////////////////////////////////////*****************************WHY INCREMENT THE QUESTION VALUE?**********************
    }
    
    updatePlayerSpeed ();
    world.getLevel (currentLevel).cleanPlatform ();
    
    Utilities.delay (50);
  }
  
  public /*synchronized*/ void platformShift (){
    //player.setSpeed (player.getSpeed () * -1);
    player.setSpeed (-30);
    
    while (player.getSpeed () < 0){
      world.getLevel (currentLevel).cleanPlatform ();
      
      for(Platform a : world.getLevel (currentLevel).getPlatforms()){
        a.setY (a.getY () - player.getSpeed());
      }
      
      player.setSpeed (player.getSpeed () + 5);
      
      //SearchingForSolvationFrame.frame.validate ();
      //SearchingForSolvationFrame.frame.repaint ();
      
      Utilities.refreshScreen ();
      Utilities.delay (50);
    }
    player.setSpeed (0);
  }
  
  public Game (Player player, World world) {
    this.player = player;
    this.world = world;
    currentLevel = 0;
  }
  
  public Game (Player player, World world, int currentLevel) {
    this.player = player;
    this.world = world;
    this.currentLevel = currentLevel;
  }
}