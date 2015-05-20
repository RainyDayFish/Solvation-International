import java.util.*;
import java.awt.*;

public abstract class World
{
    private int difficulty;
    private BufferedImage background;
    private List < GameLevel > levels;

    public int getDifficultyLevel ()
    {
	return difficultyLevel;
    }


    public GameLevel getLevel (int levelNum)
    {
	return levels.get (levelNum);
    }


    public BufferedImage getBackground ()
    {
	return background;
    }


    public List < GameLevel > getLevels ()
    {
	return levels;
    }


    public World (int difficulty, BufferedImage background, List < GameLevel > levels)
    {
	this.difficulty = difficulty;
	this.background = background;
	this.levels = levels;
    }
}
