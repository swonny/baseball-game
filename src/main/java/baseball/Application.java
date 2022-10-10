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
//    private List<Integer> answers = new ArrayList<Integer>(3); // String으로 변경하기
    String answers = new String();

    public void startGame() {
        Answer answer = new Answer();
        answers = answer.createRandomNumbers();
        boolean repeat = true;

        do {
            String userAnswers = new String();
            System.out.print("숫자를 입력해주세요 : ");
            userAnswers = Console.readLine();
            System.out.println(answers);

            if (answers.equals(userAnswers)) {
                repeat = false;
            }

        } while (repeat);
    }
}

class Answer {
    public String createRandomNumbers() {
        String answers = new String();

        for (int i = 0; i < 3; i++) {
            answers += Integer.toString(Randoms.pickNumberInRange(1, 9));
        }

        return answers;
    }
}
