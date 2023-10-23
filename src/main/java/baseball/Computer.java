package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private final int[] secretNumbers = new int[3];
    private final Set<Integer> numberSet = new HashSet<>();

    public Computer() {
    }

    private void clearNumbers() {
        numberSet.clear();
        Arrays.setAll(secretNumbers, i -> 0);
    }

    public void pickNumbers() {
        clearNumbers();
        while (numberSet.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (numberSet.contains(newNumber))
                continue;
            secretNumbers[numberSet.size()] = newNumber;
            numberSet.add(newNumber);
        }
    }

    public Map<String, Integer> countStrikesAndBalls(int[] guessNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (secretNumbers[idx] == guessNumbers[idx]) {
                strikes++;
            } else {
                if (numberSet.contains(guessNumbers[idx]))
                    balls++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("strikes", strikes);
        result.put("balls", balls);
        return result;
    }

}
