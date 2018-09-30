package trivia;

import java.util.Random;

/**
 * @author xuyiyang
 */
public class Player {

  private Random random = new Random();
  private boolean isAvailable = true;
  private int id;
  private int goldNum = 0;
  private int position = 0;

  public Player(int id) {
    this.id = id;
  }

  public void dice() {
    this.position += random.nextInt(6) + 1;
  }

  public void answer(Question question) {
    String ans = (random.nextInt(10) > 6 ? "2" : "1");
    boolean isCorrect = question.testAns(ans);
    System.out.println("A(" + id + "): " + ans + "(" + isCorrect + ")");
    if (isCorrect) {
      this.goldNum += 1;
      this.isAvailable = true;
    } else {
      this.isAvailable = false;
    }
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public int getId() {
    return id;
  }

  public int getGoldNum() {
    return goldNum;
  }

  public int getPosition() {
    return position;
  }
}
