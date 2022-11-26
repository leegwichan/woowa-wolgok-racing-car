package ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static util.ErrorMessage.*;

public class InputView {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_ATTEMPT = 1;

    public List<String> insertCars() {
        String namesInput = Console.readLine();
        isContainingComma(namesInput);
        isContainingBlack(namesInput);

        List<String> names = Arrays.stream(namesInput.split(",")).collect(Collectors.toList());
        isSingleCar(names);
        isValidNameLength(names);
        return names;
    }

    public int insertAttempts() {
        String attemptsInput = Console.readLine();
        isNumeral(attemptsInput);
        int attempts = Integer.parseInt(attemptsInput);
        isValidAttempts(attempts);
        return attempts;
    }

    private void isContainingComma(String namesInput) {
        if (!namesInput.contains(",")) {
            throw new IllegalArgumentException(SEPARATOR_NOT_EXIST_ERROR_MESSAGE);
        }
    }

    private void isContainingBlack(String namesInput) {
        if (namesInput.contains(" ")) {
            throw new IllegalArgumentException(CONTAIN_EMPTY_TEXT_ERROR_MESSAGE);
        }
    }

    private void isSingleCar(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(SINGLE_CAR_NAME_INPUT_ERROR_MESSAGE);
        }
    }

    private void isValidNameLength(List<String> names) {
        boolean isValidNameLength = names.stream()
                .allMatch(name -> name.length() <= MAXIMUM_NAME_LENGTH);
        if (!isValidNameLength) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void isNumeral(String attemptsInput) {
        try {
            Integer.parseInt(attemptsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERAL_INPUT_ERROR_MESSAGE);
        }
    }

    private void isValidAttempts(int attempts) {
        if (attempts < MINIMUM_ATTEMPT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_INPUT_ERROR_MESSAGE);
        }
    }
}
