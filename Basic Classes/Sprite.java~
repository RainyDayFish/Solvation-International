import java.awt.*;

public class Sprite extends Entities
{
    private boolean isTangible;
    private double defaultMovementSpeed = 0.95, currentMovementSpeed = defaultMovementSpeed;

    public boolean getTangibility ()
    {
	return isTangible;
    }


    public void setTangibility (boolean newTangibility)
    {
	isTangible = newTangibility;
    }


    public double getCurrentMovementSpeed ()
    {
	return currentMovementSpeed;
    }


    public void setCurrentMovementSpeed (double newSpeed)
    {
	currentMovementSpeed = newSpeed;
    }


    public void resetMovementSpeed ()
    {
	currentMovementSpeed = defaultMovementSpeed;
    }


    public Sprite (int x, int y, boolean isTangible, BufferedImage sprite)
    {
	super (x, y, sprite);
	this.isTangible = isTangible;
    }
}
