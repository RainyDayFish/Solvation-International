import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Utilities {
  static final int SCREEN_SIZE = 750;
  
  static final BufferedImage PLAY_BUTTON = getImage ("play.png");
  static final BufferedImage BACK_BUTTON = getImage ("back.png");
  static final BufferedImage HELP_BUTTON = getImage ("help.png");
  static final BufferedImage HIGH_SCORE_BUTTON = getImage ("scores.png");
  static final BufferedImage SETTINGS_BUTTON = getImage ("settings.png");
  static final BufferedImage QUIT_BUTTON = getImage ("quit.png");
  
  static final BufferedImage CLEAR_BUTTON = getImage ("trash.png");;
  static final BufferedImage NEW_GAME_BUTTON = getImage ("new.png");;
  static final BufferedImage OPEN_GAME_BUTTON = getImage ("open.png");;
  static final BufferedImage LOCKED_BUTTON = getImage ("locked.png");;
  
  static final BufferedImage CLOUDS_BACKGROUND = getImage ("Clouds.png");;
  static final BufferedImage HILLS_BACKGROUND = getImage ("Hills.png");;
  static final BufferedImage MOUNTAINS_BACKGROUND = getImage ("Mountains.png");;
  static final BufferedImage NIGHT_BACKGROUND = getImage ("Night.png");;
  static final BufferedImage OLD_URBAN_BACKGROUND = getImage ("Old Urban.png");
  static final BufferedImage DESERT_BACKGROUND = getImage ("Desert.png");
  
  static final BufferedImage DEFAULT_PLATFORM = getImage ("platform.png");
  static final BufferedImage ANSWER_PLATFORM = getImage ("platformAnswer.png");
  
  
  //*********************** ADD SPRITE IMAGE PATHS *******************************************//
  // static final BufferedImage GHOST_SPRITE;
  // static final BufferedImage SNAIL_SPRITE;
  static final BufferedImage TEMP_SPRITE = getImage ("dot.png");
  //*****************************************************************************************//
  
  public static BufferedImage getImage (String fileName){
    try {
      return ImageIO.read (new File (fileName));
    }
    catch (IOException e){
      return null;
    }
  }
  
  public static void delay (int time){
    try {
      Thread.sleep (time);
    }
    catch (Exception e){
      e.printStackTrace ();
    }
  }
}