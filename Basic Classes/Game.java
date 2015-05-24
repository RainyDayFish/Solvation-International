public class Game {
  
  Player player;
  World world;
  GameLevel currentLevel;
  int time;
  int questionNum = 0;
  
  public Player getPlayer (){
    return player;
  }
  
  public GameLevel getLevel(){
    return currentLevel;
  }
  
  public void setPlayer (Player newPlayer){
    player = newPlayer;
  }
  
  public void setLevel(GameLevel newLevel){
    currentLevel = newLevel;
  }
  
  public void pauseGame(){
    
  }
  
  public int landedWhere (){
    int counter = 0;
    for(Platform a : world.getLevel (currentLevel.getLevelNum()-1).getPlatforms ()) {
      
      if(player.getX () >= a.getX () && player.getX () <= a.getX () + 30 && player.getY () == a.getY ()) {
        return counter;
      }
      counter++;
    }
    return -1;
  }
  
  public boolean correctLanded(){
    if (currentLevel.getPlatforms(). get(landedWhere()).getText().equals(currentLevel.getQuestions().get(questionNum))){
      return true;
    }
    return false;
  }
  
  public void inGame(){
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
    }
  }
  
  public void platShift(){
    while(player.getSpeed()>0){
      for(Platform a:currentLevel.getPlatforms()){
        a.setY(a.getY()+player.getSpeed());
      }
      player.setSpeed(player.getSpeed()-2);
    }
  }
  public Game (Player player, World world) {
    this.player = player;
    this.world = world;
    currentLevel= world.getLevels().get(0);
  }
  public Game (Player player, World world,int l) {
    this.player = player;
    this.world = world;
    this.currentLevel=world.getLevels().get(l);
  }
}