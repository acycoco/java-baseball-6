package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public List<Integer> readGuessNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return covertStringToIntList(Console.readLine());
    }

    public List<Integer> covertStringToIntList(String input) {
        input = input.replaceAll("\\s", "");

        validateNumeric(input);
        validateLength(input);

        List<Integer> result = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        if (result.size() != GameConstants.NUM_DIGITS) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야됩니다. ");
        }

        return result;
    }

    private void validateNumeric(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자가 포함되어 있습니다.");
        }
    }

    private void validateLength(String input) {
        if (input.length() != GameConstants.NUM_DIGITS) {
            throw new IllegalArgumentException(GameConstants.NUM_DIGITS + "자리의 숫자가 아닙니다.");
        }
    }

    public int readRetryChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return stringToIntThrowException(Console.readLine());
    }

    private int stringToIntThrowException(String input) {
        input = input.replaceAll("\\s", "");

        if (!input.matches("[12]")) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }

        return Integer.parseInt(input);
    }
}
