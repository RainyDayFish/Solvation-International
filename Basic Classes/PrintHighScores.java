import java.awt.print.*;
import java.awt.*;

public class PrintHighScores implements Printable {
  private PrinterJob job = PrinterJob.getPrinterJob ();
  
  public int print (Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException
  {
    Graphics g2d = (Graphics2D)g;
    
    if (pageIndex > 0)
      return NO_SUCH_PAGE;
    
    g2d.translate ((int) pageFormat.getImageableX (), (int) pageFormat.getImageableY ());
    g.drawString ("testing the print", 100, 100);
    //add g.drawImage () here to print images
    
    return PAGE_EXISTS;
  }
  
  public boolean printer (){
    if (job.printDialog ()){
      try {
        job.print ();
        return true;
      }
      catch (PrinterException e){
        return false;
      }
    }
    return false;
  } 
  private PrintHighScores (){
    job.setPrintable (this);
  }
}