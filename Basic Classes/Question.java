/* This class is instantiated to create the various questions which the user answers to play the game.
 * Each Question consists of a question and answer string.
 * 
 * @author Atharva Washimkar
 * @version 1 05.21.15
 * 
 * <p>
 * <b>Instance Variables:</b>
 * <p>
 * <b>question</b> A String which stores the question that is being asked.
 * <p>
 * <b>answer</b> A String which stores the answer to the question that is being asked.
 */

public class Question
{
  private String question, answer;
  
  /* Description of getQuestion ()
   * This method returns the String which represents the question being asked.
   *
   * @return A String representing the question being asked.
   */    
  
  public String getQuestion ()
  {
    return question;
  }
  
  /* Description of getAnswer ()
   * This method returns the String which represents the answer to the asked question.
   *
   * @return A String representing the answer to the question being asked.
   */
  
  public String getAnswer ()
  {
    return answer;
  }
  
  /*
   * The constructor of the class which takes in two String parameters to initialize a new Question object with: the question and the answer.
   *
   * @param question A String representing the question being asked.
   * @param answer A String representing the answer to the question being asked.
   */
  
  public Question (String question, String answer)
  {
    this.question = question;
    this.answer = answer;
  }
}
