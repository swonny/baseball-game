package baseball;

import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String repeat = new String();
        do {
            Game game = new Game();
            game.startGame();
            repeat = Console.readLine();
        } while (repeat.equals("1"));
    }
}

class Game {
    List<Integer> answers = new ArrayList<Integer>(3);

    public void startGame() {
        System.out.println("Game has started!");
        createRandomNumbers();
        System.out.println(answers);
    }

    private void createRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            answers.add(Randoms.pickNumberInRange(1, 9));
        }
    }
}

