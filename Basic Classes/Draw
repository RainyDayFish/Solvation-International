import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Draw  extends JPanel{
  public Draw() {
    setBorder(BorderFactory.createLineBorder(Color.black));
  }
  
  public Dimension getPreferredSize() {
    return new Dimension(750,750);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);       
    Game.getWorld();
    g.drawImage(Game.getLevel().getBackground (),0,0,this);
    g.drawImage(Game.getPlayer().getImage(), Game.getPlayer().getX(), Game.getPlayer().getY(), this);
    for(Platform a:Game.getLevel().getPlatforms()){
      g.drawImage(a.getImage(), a.getX(), a.getY(), this);
      // System.out.println(getX());
    }
    //  g.drawString("This works!",10,20);
  }  
}
