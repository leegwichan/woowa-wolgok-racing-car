#기능 목록

## 자동차 게임을 관리하는 클래스 ClassName : RacingGame
- [ ] 자동차 게임을 진행하는 메서드 - #doCarGame()
- [ ] 이동 혹은 정지를 판단하는 메서드 - #checkMoveOrNot()


## 자동차의 이름, 현재 위치를 저장하는 클래스 ClassName : Car
- [ ] 자동차의 이동/혹은 정지를 관리하는 기능 - #updatePosition()
- [ ] 자동차의 이름과 현재 위치를 반환하는 기능 - #getNameAndPosition()
---
## 입력값을 관리하는 클래스 ClassName : InputView
- [ ] 경주 할 자동차 이름을 입력받기 - #insertCars()
  - 예외처리
    - [ ] `,` 가 포함되지 않은 경우 - #isNotContainingComma()
    - [ ] 한대의 차만 입력된 경우 - #isSingleCar()
    - [ ] 이름이 공백이거나 5자 이상인경우 -#isNotValidNameLength()
- [ ] 시도 횟수 입력 받기 - #insertAttempts()
  - 예외처리
    - [ ] 숫자가 아닌 값이 입력된 경우
---
## 출력값을 관리하는 클래스 ClassName : OutputView
- [ ] 파라미터의 Map<String,int> 를 주어진 형식에 맞게 출력 - #printResult()
  - [ ] 이동한 거리의 숫자만큼 `-` 를 반환하는 기능 : #getMoving()
- [ ] 우승자 안내 문구 출력 - #printWinner()
---
## 이동/정지 값을 가지는 열거형 클래스 ClassName : Movement
- 멤버 : MOVE,STOP
---
## 난수를 생성하는 클래스 ClassName : NumberGenerator
- [ ] 0~9 사이의 난수를 생성하는 클래스 -#createRandomNumber()
