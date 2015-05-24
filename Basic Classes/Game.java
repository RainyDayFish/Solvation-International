import java.util.*;

public class Game {
  
  Sprite chosenSprite;
  Score score;
  World world;
  GameLevel currentLevel;
  
  int questionNum = 0;
  int lives = 4 - currentLevel.getLevelNum ();
  int speed = 0;
  int time;
  
  public Sprite getChosenSprite(){
    return chosenSprite;
  }
  
  public Score getScore(){
    return score;
  }
  
  public GameLevel getLevel(){
    return currentLevel;
  }
  
  public void setChosenSprite(Sprite sprite){
    chosenSprite=sprite;
  }
  
  public void setLevel(GameLevel newLevel){
    currentLevel = newLevel;
  }
  
  public void setScore(Score newScore){
    score = newScore;
  }
  
  public void pauseGame(){
    
  }
  
  public int landedWhere(){
    int counter=0;
    for(Platform a : world.getLevel(level).getPlatform()){
      
      if(chosenSprite.getX()>=a.getX()&&chosenSprite.getX()<=a.getX()+30&&chosenSprite.getY()==a.getY()){
        return counter;
      }
      counter++;
    }
    return -1;
  }
  
  public boolean correctLanded(){
    if (world.getLevel(level).getPlatform(). get(landedWhere()).getText.equals(world.getLevel(level).getQuestions().get(questionNum))){
      return true;
    }
    return false;
  }
  
  public void inGame(){
    time=(int)world.getLevel(level).getTimeLimit();
    while(lives>0){
      time--;
      chosenSprite.setY(chosenSprite.getY()+speed);
      if(landedWhere()>-1){
        
        if(chosenSprite.getY()<250){
          platShift();
        }else {
          speed*=-1;
        }
      }else{
        if(chosenSprite.getY()<=world.getLevel(level).getLowest()+50){
          lives--;
          chosenSprite.setY(world.getLevel(level).getLowest());
          speed=10;
        }
      }
      if(correctLanded()){
        time=(int)world.getLevel(level).getTimeLimit();
      }else{
        if (time<1){
          lives--;
          time=(int)world.getLevel(level).getTimeLimit();
        }
      }
      
      speed+=2;
      world.getLevel(level).cleanP();
    }
  }
  
  public void platShift(){
    while(speed>0){
      for(Platform a:world.getLevel(level).getPlatforms()){
        a.setY(a.getY()+speed);
      }
      speed -=2;
    }
  }
  
  public Game(Sprite chosenSprite, Score score){
    this.chosenSprite = chosenSprite;
    this.score = score;
    
    List <GameLevel> levels = new ArrayList <GameLevel>();
    
    world = new World (score.getDifficulty (), new ArrayList <GameLevel> ());
  }
}