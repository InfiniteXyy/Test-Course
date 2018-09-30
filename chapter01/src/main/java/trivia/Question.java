package trivia;

/**
 * @author xuyiyang
 */
public class Question {

  private String description;
  private String answer;

  public Question(String description, String answer) {
    this.description = description;
    this.answer = answer;
  }

  public String getDescription() {
    return description;
  }

  public boolean testAns(String answer) {
    return answer.equals(this.answer);
  }
}
