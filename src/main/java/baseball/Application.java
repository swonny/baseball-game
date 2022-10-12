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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            repeat = Console.readLine();
        } while (repeat.equals("1"));
    }
}

class Game {
    private Answer answer;
    private UserInput userInput;

    public void startGame() {
        answer = new Answer(); // 난수 생성

        boolean correct = true;
        do {
            String userAnswers = new String();
            System.out.print("숫자를 입력해주세요 : ");
            userInput = new UserInput(); // 사용자 숫자 입력
            correct = answer.getHint(userInput.userAnswers);
        } while (!correct);
    }
}

class Answer {
    private String answers = new String();

    Answer() {
        while (answers.length() < 3) {
            String tmp = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!answers.contains(tmp)) {
                answers += tmp;
            }
        }
        System.out.println(answers);
    }

    public boolean getHint(String userAnswers) {
        int strike = countStrike(userAnswers);
        int ball = countBall(userAnswers);
        ball -= strike;
        String output = new String();
        if (ball > 0) {
            output += Integer.toString(ball) + "볼 ";
        }
        if (strike > 0) {
            output += Integer.toString(strike) + "스트라이크 ";
        }
        if (ball == 0 && strike == 0) {
            output += "낫싱";
        }
        System.out.println(output);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private int countBall(String userAnswers) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (userAnswers.indexOf(answers.charAt(i)) > -1) {
                count += 1;
            }
        }
        return count;
    }

    private int countStrike(String userAnswers) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (answers.charAt(i) == userAnswers.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}

class UserInput {
    String userAnswers;

    UserInput() {
        String tmp = Console.readLine(); // 숫자 입력
        checkException(tmp);
        userAnswers = tmp;
    }

    public void checkException(String userAnswers) throws IllegalArgumentException {
        if (userAnswers.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            int tmp = (int) userAnswers.charAt(i);
            if (tmp < (int) '1' || tmp > (int) '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
