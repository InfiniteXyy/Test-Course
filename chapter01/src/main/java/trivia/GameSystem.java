package trivia;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyiyang
 */
public class GameSystem {

  private List<GamePosition> map = new ArrayList<>();
  private List<Player> players = new ArrayList<>();

  public GameSystem(int mapSize, int playerNum) {
    for (int i = 0; i < mapSize; i++) {
      map.add(new GamePosition(i, QuestionMaker.getRandomQuestion()));
    }
    for (int i = 0; i < playerNum; i++) {
      players.add(new Player(i));
    }
  }

  void start() {
    boolean hasWinner = false;
    while (!hasWinner) {
      for (Player player : players) {
        if (player.isAvailable()) {
          player.dice();
        }
        player.answer(map.get(player.getPosition()).getQuestion());
        if (player.getGoldNum() == 6) {
          hasWinner = true;
          System.out
              .println("Winner is " + player.getId() + " on Position " + player.getPosition());
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    GameSystem game = new GameSystem(100, 3);
    game.start();
  }

}
