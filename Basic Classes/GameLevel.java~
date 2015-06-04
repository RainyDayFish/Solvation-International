
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

/* This class is used to instantiate various levels of the game for the user to play.
 * 
 * @author Atharva Washimkar
 * @version 1 05.22.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>levelNum</b> An int which specifies which level the player is on.
 * <p>
 * <b>timeLimit</b> A double which specifies the amount of time that the user has to complete the level.
 * <p>
 * <b>background</b> A BufferedImage which is used to visually represent the level on the screen.
 * <p>
 * <b>platforms</b> A List of Platforms which contain the amount of Platforms within the level.
 * <p>
 * <b>questions</b> A List of Question objects which are asked by the program and are answered by the user during the level.
 */

public class GameLevel
{
  private int levelNum;
  private double timeLimit;
  private BufferedImage background;
  private List < Platform > platforms=new ArrayList<Platform>();
  private List <Question> questions=new ArrayList<Question>();
  
  /* Description of getLevelNum ()
   * This method returns an int which represents the level number.
   *
   * @return An int which represents the level number.
   */
  
  public int getLevelNum ()
  {
    return levelNum;
  }
  
  /* Description of getTimeLimit ()
   * This method returns a double value which represents the amount of time the user has to complete the level.
   *
   * @return A double value which represents the amount of time the user has to complete the level.
   */
  
  public double getTimeLimit ()
  {
    return timeLimit;
  }
  
  /* Description of getBackground ()
   * This method returns a BufferedImage which visually represents the level on the screen.
   *
   * @return A Buffered image which visually represents the level on the screen.
   */
  
  public BufferedImage getBackground (){
    return background;
  }
  
  /* Description of getPlatforms ()
   * This method returns a List of Platforms which represents the Platform objects on the screen.
   *
   * @return A List of Platforms which represents the Platform objects on the screen.
   */
  
  public List < Platform > getPlatforms ()
  {
    return platforms;
  }
  
  public List<Platform> getThreadSafePlatforms(){
    return new ArrayList<Platform>(platforms);
  }
  /* Description of getQuestions ()
   * This method returns a List of Questions which represents the questions asked to the user during the level.
   *
   * @return A List of Questions which represents the questions asked to the user during the level.
   */
  
  public List <Question> getQuestions(){
    return questions;
  }
  
  /* Description of exists()
   * This method checks if the parameter platform is in the same location as another platform
   *
   * @param p is the platform in question.
   */
  private boolean exists(Platform p){
    if(p.getX()>650||p.getY()>725){
      return true;
    }
    for(int f=0;f<platforms.size();f++){
      if((platforms.get(f).getX()<p.getX()+250&&platforms.get(f).getX()+250>p.getX())&&(platforms.get(f).getY()>p.getY()-100&&platforms.get(f).getY()-100<p.getY())){
        return true;
      }
      
    }
    return false;
    
  }
  
  
  public void generatePlatforms (int difficultyLevel)
  {
    Platform p;
    BufferedImage pic;
    BufferedImage platPic;
    for(int f=0;f<questions.size();f++){
      try{
        //pic=ImageIO.read(new File(questions.get(f).getAnswer()));
        //pic= null;
        pic=ImageIO.read(new File("PlatformAnswer.png"));
        p=new Platform((int)(Math.random()*750),(int)(Math.random()*750),questions.get(f).getAnswer(),pic);
        if(!exists(p)){
          platforms.add(p);
        }else{
          f--;
        }
        
      }catch(Exception e){
        
      }
    }
    for (int i = 0; i < 200 - (difficultyLevel * 25); i++){
      try{
        platPic=ImageIO.read(new File("Platform.png"));
        p=new Platform((int)(Math.random()*750),(int)(Math.random()*100+i*100),"",platPic);
        if(platforms.size()==0||!exists(p)){
          // System.out.println(p.getX());
          platforms.add(p);
        }
      }catch(IOException e){
      }
    }
    
  }
  /* Description of inputQuestions ()
   * This method assigns the values of questions from an external .txt file.
   */
  public void inputQuestions(int diffLevel){
    try{
      BufferedReader open=new BufferedReader(new FileReader("Questions"+diffLevel+".txt"));
      String temp;
      String answer;
      while((temp=open.readLine())!=null){
        answer=open.readLine();
        questions.add(new Question(temp,answer));
      }
    }catch(IOException e){
      e.printStackTrace(System.out);
    }
    
  }
  
  /* Description of removePlatform ()
   * This method removes a certain index passed as a parameter from the Platform List.
   *
   * @param num An int which represents the index to remove within the platforms List.
   */
  
  public void removePlatform (int num){
    platforms.remove(num);
  }
  
  /* Description of getLowest ()
   * This method returns the y value of the lowest Platform object within a List.
   *
   * @return An int which represents the y value of the lowest Platform object within a List.
   */
  
  public int getLowest (){
    return platforms.get(getLowestPlatform()).getY();
  }
  
  public int getLowestPlatform (){
    int low=0;
    for(int f=0;f<platforms.size();f++){
      if(platforms.get(f).getY()>low){
        low=f;
      }
    }
    return low;
  }
  /* Description of getLowest ()
   * This method returns the y value of the highest Platform object within a List.
   *
   * @return An int which represents the y value of the highest Platform object within a List.
   */
  
  public int getHighest(){
    int high=platforms.get(0).getY();
    for(int f=0;f<platforms.size();f++){
      if(platforms.get(f).getY()<high){
        high=platforms.get(f).getY();
      }
    }
    return high;
  }
  private void makePossible(){
    
    
    Collections.sort(platforms);
    for(int f=0;f<platforms.size()-1;f++){
      
      //  if(Math.pow(2.0,(double)(platforms.get(f+1).getY()-platforms.get(f).getY()))+Math.pow(2.0,(double)(platforms.get(f+1).getX()-platforms.get(f).getX()))>40000){
      //if(platforms.get(f+1).getY()-platforms.get(f).getY()+platforms.get(f+1).getX()-platforms.get(f).getX()>200){
      if(platforms.get(f+1).getY()-platforms.get(f).getY()>200){
        platforms.add(f+1,platforms.get(f));
        platforms.get(f+1).setY(platforms.get(f+1).getY()+100);
      }
    }
    
    
    
  }
  /* Description of cleanPlatform ()
   * This method checks if a Platform's y value is off the screen, and if so, re-adds it to the top.
   */
  
  public void cleanPlatform (){
    if(platforms.size()>150){
      for(int f=0;f<platforms.size();f++){
        if(platforms.get(f).getY()>0&&platforms.get(f).getY()<750){
          platforms.remove(f);
        }
      }
    }
    for(int f=0;f<platforms.size();f++){
      if(platforms.get(f).getY()>750){
        platforms.get(f).setY(getHighest()-platforms.get(f).getY()+700);
      }
    }
    makePossible();
  }
  
  /* 
   * This constructors creates a new GameLevel with the attributes of levelNum, the time limit and the background passed in as parameters
   * and are assigned to the instance variables.
   *
   * @param levelNum An int which represents the level number of the GameLevel.
   * @param timeLimit A double which represents the time limit the user has to complete the level.
   * @param background A BufferedImage which visually represents the background onto the screen.
   */
  
  public GameLevel (int levelNum, double timeLimit, BufferedImage background)
  {
    this.levelNum = levelNum;
    this.timeLimit = timeLimit;
    this.background = background;
    generatePlatforms (levelNum);
    inputQuestions(levelNum);
  }
}
