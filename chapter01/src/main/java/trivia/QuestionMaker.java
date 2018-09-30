package trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xuyiyang
 */
public class QuestionMaker {

  private static Random random = new Random();
  private static List<Question> questions = new ArrayList<Question>() {{
    add(new Question("1 + 1 = ?", "2"));
  }};

  public static Question getRandomQuestion() {
    return questions.get(random.nextInt(questions.size()));
  }

  public static void insertQusetion(String description, String ans) {
    questions.add(new Question(description, ans));
  }

}
