package racingcar.view.output;

import racingcar.car.dto.CarDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView extends OutputViewText{

    public void printCarsProgress(List<CarDto> carDtos) {
        print(BLANK_LINE);
        for (CarDto carDto : carDtos) {
            printCarProgress(carDto);
        }
    }

    private void printCarProgress(CarDto carDto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carDto.getName())
                .append(CAR_PROGRESS_FROM)
                .append(POSITION.repeat(carDto.getPosition()));

        print(stringBuilder);
    }

    public void printResult(List<CarDto> carDto) {
        List<CarDto> winners = getWinners(carDto);
        print(BLANK_LINE);
        printWinners(winners);
    }

    private List<CarDto> getWinners(List<CarDto> carDtos) {
        int maxPosition = 0;
        List<CarDto> winners = new ArrayList<>();

        for (CarDto carDto : carDtos) {
            if (carDto.getPosition() > maxPosition) {
                winners = new ArrayList<>();
                maxPosition = carDto.getPosition();
                winners.add(carDto);
                continue;
            }
            if (carDto.getPosition() == maxPosition) {
                winners.add(carDto);
            }
        }
        return winners;
    }

    private void printWinners(List<CarDto> carDtos) {
        String winners = carDtos.stream()
                .map(carDto -> carDto.getName())
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(WINNER_COMMENT + winners);
    }

    private void print(StringBuilder sb) {
        System.out.println(sb);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
