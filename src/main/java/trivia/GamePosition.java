package trivia;

import java.util.List;

/**
 * @author xuyiyang
 */
public class GamePosition {
  private int index;
  private Question question;
  private List<Player> players;

  public GamePosition(int index, Question question) {
    this.index = index;
    this.question = question;
  }

  public Question getQuestion() {
    return question;
  }
}
