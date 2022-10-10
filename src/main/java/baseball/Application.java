package baseball;

import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String repeat;
        do {
            startGame();
            repeat = Console.readLine();
            System.out.println(repeat);
        } while (repeat.equals("1"));
    }

    public static void startGame() {
        System.out.println("Game has started!");
    }
}
