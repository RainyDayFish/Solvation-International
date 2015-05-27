public class Utilities {
  
  static final int SCREEN_SIZE = 750;
  
  public static int randInt (int min, int max){
    return (int) (Math.random () * (max - min) + min);
  }  
  
  private Utilities (){}
}