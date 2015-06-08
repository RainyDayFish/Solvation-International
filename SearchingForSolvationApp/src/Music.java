import sun.audio.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
public class Music implements Runnable{
  private boolean stop=false;
  private boolean playing=true;
  public void setStop(){
    stop=true;
  }
  public void setPlay(){
    stop=false;
  }
  public boolean getPlaying(){
    return playing;
  }
  public void play(){
    System.out.println("1");
    try{
      URL url = Music.class.getResource("The Weeknd - Earned It.wav");
      AudioClip clip = Applet.newAudioClip(url);
      AudioClip clip2 = Applet.newAudioClip(url);
      clip.loop();
      
//  Thread.sleep(1000);
//  clip2.loop();
      while(true){
        //System.out.println(stop);
        if(stop&&playing){
          // System.out.println("Stoped");
          clip.stop();
          playing=false;
        }else{
          if(!playing&&!stop){
            // System.out.println("Play");
            clip.loop();
            playing=true;
          }
        }
      }
      // clip2.stop();
    }catch(Exception e){}
    System.out.println("end");
  }
  
  public Music(){
    //music();
    // play();
  }
  public void run(){
    play();
  }
}