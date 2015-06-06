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
  private boolean won=false;
  private int score=0;
  //private JFrame f = new JFrame("Game");
  
  public Player getPlayer (){
    return player;
  }
  public boolean getWon(){
  return won;
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
  public static Game run(int worldNum, Game g, String charName){
    if(worldNum==1){
      try{
        BufferedImage character=ImageIO.read(new File(charName+"L.png"));
        BufferedImage back1=ImageIO.read(new File("Clouds.png"));
        BufferedImage back2=ImageIO.read(new File("Hills.png"));
        BufferedImage back3=ImageIO.read(new File("Night One.png"));
        
//      List backgrounds=new arrayList <BufferedImage> ();
//      backgrounds.add(back1);
//      backgrounds.add(back2);
//      backgrounds.add(back3);
        
        List<GameLevel> levels=new ArrayList<GameLevel>();
        levels.add(new GameLevel(1, 500, back1,true,1));
        levels.add(new GameLevel(2, 500, back2,true,1));
        levels.add(new GameLevel(3, 500, back3,true,1));
        g=new Game(new Player(250, 0, true, character , charName), new World(1,  levels));
        System.out.println(g.getPlayer().getName());
        //   for(Platform a:Game.getLevel().getPlatforms()){
        // System.out.println(a.getX());
        //  }
        //g.drawGame();
        //g.inGame();
        
      }catch(IOException e){
        System.out.println("I messed up");
      }
    }else if(worldNum==2){
      try{
        BufferedImage character=ImageIO.read(new File(charName+"L.png"));
        BufferedImage back1=ImageIO.read(new File("Weird.png"));
        BufferedImage back2=ImageIO.read(new File("Old Urban.png"));
        BufferedImage back3=ImageIO.read(new File("Mountains.png"));
        
//      List backgrounds=new arrayList <BufferedImage> ();
//      backgrounds.add(back1);
//      backgrounds.add(back2);
//      backgrounds.add(back3);
        
        List<GameLevel> levels=new ArrayList<GameLevel>();
        levels.add(new GameLevel(1, 500, back1,true,2));
        levels.add(new GameLevel(2, 500, back2,true,2));
        levels.add(new GameLevel(3, 500, back3,true,2));
        g=new Game(new Player(250, 0, true, character ,charName), new World(2,  levels));
        //   for(Platform a:Game.getLevel().getPlatforms()){
        // System.out.println(a.getX());
        //  }
        //g.drawGame();
        // g.inGame();
        
      }catch(IOException e){
        System.out.println("I messed up2");
      }
    }else{
      System.out.println("Wait for update 2.7");
    }
    return g;
  }
  
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
      score+=timeLeft;
      player.setScore(new Score("",score,world.getDifficultyLevel(), currentLevel+1));
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
    if (landedWhere () > -1 && player.getTan ()){
      if (player.getY () < 300){
        platformShift ();
      }
      else {
        if (correctLanded ()){
         // System.out.println ("correct");
          
          timeLeft = world.getLevel (currentLevel).getTimeLimit ();
          questionNum++;
          System.out.println(" Score"+ player.getScore().getScore());
          
          //System.out.println("Question Num:"+questionNum);
         // System.out.println(questionNum >= world.getLevel (currentLevel).getQuestions ().size ());
          if(hasWonLevel()){
                  System.out.println("New Level!");
              questionNum=0;
              if(world.getLevels().get(currentLevel).getLevelNum()<world.getLevels().size()){
                currentLevel=world.getLevels().get(currentLevel).getLevelNum();
                player.setScore(new Score("",score,world.getDifficultyLevel(), currentLevel+1));
                Utilities.refreshScreen ();
                try {
                  Thread.sleep(1000);
                } catch (Exception e) {
                  System.out.println(e);
                }
                player.setLives(player.getLives()-1);
                player.setY(250);
                player.setX(world.getLevels().get(currentLevel).getPlatforms().get(world.getLevels().get(currentLevel).getLowestPlatform()).getX());
                player.setSpeed(25);
                try {
                  Thread.sleep(1000);
                } catch (Exception e) {
                  System.out.println(e);
                }
              }else{
                return true;
              }
//               questionNum=0;
//            return true;
          }
        }
        if(landedWhere()>-1){
        System.out.println ("Landed!!!!: " + player.getSpeed () + " " + landedWhere () + " " + world.getLevel (currentLevel).getPlatforms ().get (landedWhere ()).getText () + " Lives: " + player.getLives ());
        System.out.println (timeLeft);
      //  System.out.println(questionNum+" "+world.getLevels().get(currentLevel).getQuestions().size());
        }
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
  
  public boolean updateGameState (){
    timeLeft--;
    player.setY (player.getY () + player.getSpeed ());
    
    updatePlayerXPosition ();
    
    if (updateLanding ()){
   // if (true){
      System.out.println("Yes I leave");
      won=true;
      return true;
    }
    
    if (timeLeft < 1){
      player.setLives (player.getLives () - 1);
      //timeLeft = world.getLevel (currentLevel).getTimeLimit ();
      Utilities.delay (2000);
      
      timeLeft = world.getLevel (currentLevel).getTimeLimit ();
      questionNum++;                      /////////////////////////////////////////*****************************WHY INCREMENT THE QUESTION VALUE?**********************
    }
    
    updatePlayerSpeed ();
    world.getLevel (currentLevel).cleanPlatform ();
    return false;
//<<<<<<< HEAD
//<<<<<<< HEAD
    //Utilities.delay (50);
//=======
    // Utilities.delay (10);
//>>>>>>> origin/master
//=======
    // Utilities.delay (10);
//>>>>>>> origin/master
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
  
  public Game(){
    
  }
}
