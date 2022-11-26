package racingcar.view.output;

import racingcar.car.dto.CarDto;
import java.util.List;

public class OutputView extends OutputViewText{

    public void printCarsProgress(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            printCarProgress(carDto);
        }
    }

    private void printCarProgress(CarDto carDto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carDto.getName())
                .append(" : ")
                .append("-".repeat(carDto.getPosition()));

        print(stringBuilder);
    }

    public void printResult(List<CarDto> carDto) {

    }

    private void print(StringBuilder sb) {
        System.out.println(sb);
    }
}
