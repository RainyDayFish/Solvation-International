import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
//import java.awt.font.TextAttribute; *****************ONLY NEEDED IF CROSSING OUT TEXT

public class CoverFlowMenu extends JPanel implements KeyListener, MouseListener {
  
  private ArrayList <CoverFlowMenuItem> items;
  private String title;
  private int current = 0, start, end, choice;
  private boolean move = true, choseOption;
  private int [] endX = {20, 275, 600}, endY = {300, 300, 300};
  
  public void paintComponent (Graphics g) {
    // g.setColor (Color.WHITE);
    //g.drawRect (263, 268, 228, 250);
    if (!choseOption){
      if (move){
        displayMenu (g);
        move = false;
      }
    }
  }
  
  private void displayMenu (Graphics g){
    int [] indexes = {start, current, end};
    
    drawBackground (g);
    
    for (int i = 0; i < indexes.length ; i++){
      drawItem (g, indexes [i], items.get (indexes [i]).getX (), items.get (indexes [i]).getY (), indexes [i] == current ? 200 : /*100*/125);
    }
  }
  
  private void drawBackground (Graphics g){
    ((Graphics2D)g).setPaint (new GradientPaint( 0, 0, Color.BLACK, 0, 750, new Color (40, 40, 40)));
    g.fillRect(0, 0, 750, 750);
    
    g.setFont (new Font ("Arial", Font.PLAIN, 45));
    g.setColor (Color.WHITE);
    g.drawString (title, 20, 60);
    
    g.setFont (new Font ("Arial", Font.PLAIN, 15));
    g.drawString ("Scroll = arrow keys or clicking on the left/right side of the screen.", 20, 100);
    g.drawString ("Select = Pressing Enter/clicking the chosen icon", 20, 130);
    g.drawString ("Can also use a keyboard shortcut (always the first letter of the option's name)", 20, 160);
  }
  
  private void drawItem (Graphics g, int index, int x, int y, int scale){
    BufferedImage img = items.get (index).getImage ();
    
    if (index != current){
      img = getReflection (g, getScaledImage (img, scale), 0.3f);
    }
    else{
      img = getScaledImage (img, 200);
    }
    
    if (!items.get (index).getIsSelectable ()){
      img = blackOut (img);
    }
    
    Font font = new Font ("Arial", Font.PLAIN, 20);;
    
    /*  if (!items.get (index).getIsSelectable ())          ****************************************TEXT CROSS OUT ****************************
     {
     Map attributes = font.getAttributes ();
     attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
     font = new Font (attributes);
     }*/ 
    
    g.setColor (Color.WHITE);
    g.setFont (font);
    
    AffineTransform a = new AffineTransform ();
    
    a.translate (x, y);
    
    //if (index != chosenIndex)
    a.shear (0, -0.125);
    //a.shear (0, index == start ? 0.2 : -0.2);
    
    ((Graphics2D)g).drawImage (img, a, null);
    
    BufferedImage mirror = getReflection (g, img, 0.4f);
    
    a = new AffineTransform ();
    a.translate (x, y + mirror.getHeight () + 5);
    
    //if (index != chosenIndex)
    a.shear (0, -0.125);
    //a.shear (0, index == start ? 0.2 : -0.2);
    
    ((Graphics2D) g).drawImage (mirror, a, null);
    //g.drawImage (getReflection (g, img), x, y + img.getHeight () + 10, null);
    if (index == current)
      g.drawString (items.get (index).getName (), x + img.getWidth () / 2 - items.get (index).getName ().length () * 5, y + img.getHeight () + 60);
  }
  
  private BufferedImage blackOut (BufferedImage img){
    int color;
    
    for (int x = 0; x < img.getWidth (); x++){
      for (int y = 0; y < img.getHeight (); y++){
        color = img.getRGB (x, y);
        if (((color >> 24) & 0xff) > 0)//checks transparency of image, 0 = completely transparent
          img.setRGB (x, y, new Color (0, 0, 0).getRGB ());
      }
    }
    return img;
  }
  
  private BufferedImage getReflection (Graphics g, BufferedImage img, float opacity){
    float fadeHeight = 0.3f;
    
    BufferedImage reflection = new BufferedImage(img.getWidth (), img.getHeight (), BufferedImage.TYPE_INT_ARGB);
    Graphics2D rg = reflection.createGraphics();
    
    rg.drawRenderedImage(img, null);
    rg.setComposite (AlphaComposite.getInstance (AlphaComposite.DST_IN));
    
    //TRANSPARENCY
    rg.setPaint(new GradientPaint (0, img.getHeight () * fadeHeight, new Color( 0.0f, 0.0f, 0.0f, opacity),0, img.getHeight (), new Color( 0.0f, 0.0f, 0.0f, 0.0f)));
    rg.fillRect(0, 0, img.getWidth (), img.getHeight ());
    rg.dispose();
    
    return reflection;
  }
  
  private void setDisplayedIndexes (){
    start = current - 1;
    end = current + 1;
    
    if (current == 0)
      start = items.size () - 1;
    else {
      if (current == items.size () - 1)
        end = 0;
    }
    
    int [] indexes = {start, current, end};
    
    for (int i = 0 ; i < indexes.length ; i++){
      items.get (indexes [i]).setX (endX [i]);
      items.get (indexes [i]).setY (endY [i]);
    }
  }
  
  private void shiftLeft (){
    current = start;
    setDisplayedIndexes ();
    move = true;
  }
  
  private void shiftRight (){
    current = end;
    setDisplayedIndexes ();
    move = true;
  }
  
  private void choseChoice (){
    if (items.get (current).getIsSelectable ()){
      choseOption = true;
      choice = current;
    }
    else{
      JOptionPane.showMessageDialog (this, "This option has been disabled.", "Invalid Choice", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  private BufferedImage getScaledImage (Image srcImg, int size){
    BufferedImage resized = new BufferedImage(size, size, BufferedImage.TRANSLUCENT);
    Graphics2D g2 = resized.createGraphics();
    
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, size, size, null);
    g2.dispose();
    
    return resized;
  }
  
  public Dimension getPreferredSize() {
    return new Dimension (750, 750);
  }
  
  public void keyPressed (KeyEvent e){
    if (e.getKeyCode () == KeyEvent.VK_LEFT){
      shiftLeft ();
      repaint ();
    }
    else if (e.getKeyCode () == KeyEvent.VK_RIGHT){
      shiftRight ();
      repaint ();
    }
    else if (e.getKeyCode () == KeyEvent.VK_ENTER){
      choseChoice ();
    }
    else {
      for (int i = 0; i < items.size (); i++){
        if (items.get (i).getKeyAccess () == e.getKeyCode ()){
          current = i;
          setDisplayedIndexes ();
          move = true;
          repaint ();
          choseChoice ();
        }
      }
    }
  }
  
  public void keyTyped (KeyEvent e){}
  
  public void keyReleased (KeyEvent e){}
  
  public void mouseExited (MouseEvent e){}
  
  public void mousePressed (MouseEvent e){
    if (e.getX () >= 0 && e.getX () <= 200){
      shiftLeft ();
      repaint ();
    }
    else if (e.getX () >= 263 && e.getX () <= 491 && e.getY () >= 268 && e.getY () <= 518)
      choseChoice ();
    else {
      if (e.getX () <= 750 && e.getX () >= 550){
        shiftRight ();
        repaint ();
      }
    }
  }
  
  public void mouseEntered (MouseEvent e){}
  
  public void mouseReleased (MouseEvent e){}
  
  public void mouseClicked (MouseEvent e){}
  
  
  public CoverFlowMenu (ArrayList <CoverFlowMenuItem> items, String title){
    this.items = items;
    this.title = title;
    
    setDisplayedIndexes ();
    
    addKeyListener (this);
    addMouseListener (this);
    this.setFocusable (true);
    setDoubleBuffered (true);
  }
  
  public int getChoice (){
    while (!choseOption){
      paintComponent (getGraphics ());
    }
    return choice;
  }
}