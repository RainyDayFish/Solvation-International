public class Score
{
    private String name;
    private int difficulty, level, score;

    public String getName ()
    {
	return name;
    }


    public int getScore ()
    {
	return score;
    }


    public int getLevel ()
    {
	return level;
    }


    public int getDifficulty ()
    {
	return difficulty;
    }


    public void setName (String newName)
    {
	name = newName;
    }


    public void setScore (int newScore)
    {
	score = newScore;
    }


    public void setDifficulty (int newDifficulty;
    )
    {
	difficulty = newDifficulty;
    }


    public void setLevel (int newLevel)
    {
	level = newLevel;
    }


    public Score (String name, int score, int difficulty, int level)
    {
	this.name = name;
	this.score = score;
	this.difficulty = difficulty;
	this.level = level;
    }
}
