import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.applet.Applet;
import java.applet.AudioClip;
public class Utilities {
  static final int SCREEN_H = 800;
   static final int SCREEN_W = 750;
  
  static final BufferedImage PLAY_BUTTON = getImage ("play.png");
  static final BufferedImage BACK_BUTTON = getImage ("back.png");
  static final BufferedImage HELP_BUTTON = getImage ("help.png");
  static final BufferedImage HIGH_SCORE_BUTTON = getImage ("scores.png");
  static final BufferedImage SETTINGS_BUTTON = getImage ("settings.png");
  static final BufferedImage QUIT_BUTTON = getImage ("quit.png");
  static final BufferedImage PLUS_BUTTON = getImage ("plus.png");
  static final BufferedImage SNAIL_BUTTON = getImage ("snailButton.png");
  static final BufferedImage DOT_BUTTON = getImage ("DotButton.png");
  static final BufferedImage BIO_BUTTON = getImage ("BioButton.png");
  static final BufferedImage SOUND_BUTTON = getImage ("SoundButton.png");
  static final BufferedImage CANADA_BUTTON = getImage ("Canada.png");
  static final BufferedImage ASIA_BUTTON = getImage ("Asia.png");
  static final BufferedImage WORLD_BUTTON = getImage ("World.png");
  static final BufferedImage TRAVEL_BUTTON = getImage ("Travel.png");
  
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
  static final BufferedImage HEART_ICON = getImage ("Heart.png");
  static final ImageIcon SPLASH= new ImageIcon("Splash Screen.gif");
  static final BufferedImage HELP= getImage("Help Background.png");
  static final BufferedImage GOODBYE=getImage("Goodbye.png");
  static final BufferedImage BIO=getImage("bio.png");
 // static final AudioClip BMUSIC=Applet.newAudioClip(new Url("file:\C:\Users\ryan\Downloads\Solvation-International-master MAIN MENU\Solvation-International-master MAIN MENU\Solvation-International-master\Basic Classes\The Weeknd - Earned It .mp3"));

  //*********************** ADD SPRITE IMAGE PATHS *******************************************//
  // static final BufferedImage BALL_SPRITE;
  // static final BufferedImage SNAIL_SPRITE;
//  static final BufferedImage BALLL = getImage ("dotL.png");
//   static final BufferedImage BALLR = getImage ("dotR.png");
 //   static final BufferedImage SNAILL= getImage("SnailL.png");
 // static final BufferedImage SNAILR= getImage("SnailR.png");
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
  
  public static void refreshScreen (){
    SearchingForSolvationFrame.frame.revalidate ();
    SearchingForSolvationFrame.frame.repaint ();
  }
}
