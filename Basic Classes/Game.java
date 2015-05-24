public class Game {
  
  Player player;
  
  World world;
  GameLevel currentLevel;
  
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
  
  /*public int landedWhere (){
   int counter = 0;
   for(Platform a : world.getLevel (level).getPlatform ()) {
   
   if(player.getX () >= a.getX () && player.getX () <= a.getX () + 30 && player.getY () == a.getY ()) {
   return counter;
   }
   counter++;
   }
   return -1;
   }*/
  
  /*public boolean correctLanded(){
   if (world.getLevel(level).getPlatform(). get(landedWhere()).getText.equals(world.getLevel(level).getQuestions().get(questionNum))){
   return true;
   }
   return false;
   }*/
  
  /*public void inGame(){
   time=(int)world.getLevel(level).getTimeLimit();
   while(lives>0){
   time--;
   player.setY(player.getY()+speed);
   if(landedWhere()>-1){
   
   if(player.getY()<250){
   platShift();
   }else {
   speed*=-1;
   }
   }else{
   if(player.getY()<=world.getLevel(level).getLowest()+50){
   lives--;
   player.setY(world.getLevel(level).getLowest());
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
   }*/
  
  /*public void platShift(){
   while(speed>0){
   for(Platform a:world.getLevel(level).getPlatforms()){
   a.setY(a.getY()+speed);
   }
   speed -=2;
   }
   }*/
  
  public Game (Player player, World world) {
    this.player = player;
    this.world = world;
  }
}