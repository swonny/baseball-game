package baseball;

import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;

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
    public void startGame() {
        System.out.println("Game has started!");
    }
}

