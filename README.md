# java-blackjack
블랙잭 게임 미션 저장소

## 실행 예제

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason
tony,kimilm

딜러와 pobi, jason에게 2장의 카드를 나누어 주었습니다.
딜러: 3다이아몬드, 9클로버
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```
## 기능목록
- inputParticipant 게임 참여자 이름 입력받는 입력 메서드 (tdd x)
  input : x 
  output : String participants
- parseParticipant 게임참여자 구분하는 메서드
  input : String participants
  output: List<String or Participant> participants
- allocateCard : 카드 분배 메서드
  player 클래스 내에 구현 해놓을 생각.
  input : x
  output : List<Card> allocateResult
- provideOneCard : 플레이어 카드의 총합으로 보고 21넘지는 않는 다면 동작하는 메서드
  input : x
  output : Card providedCard
- checkDealerCard : 딜러의 카드 합이 16이하면 카드 제공하는 메서드
  input : x
  output : x
- sumTotalCardNum : 한사람당 각 카드의 숫자 값을 합치는 메서드
  input : Participant participant
  output : int score
- 승패를 정리하다(마땅한 메서드명이 떠오르질 않아서 임시로,,) : 딜러와 플레이어들의 승패를 계산하는 메서드
  input : List<Participant> participants  
  output : List<Participant> participants -> 애매


## 1단계 요구사항

- [] 블랙잭 게임을 변형한 프로그램을 구현한다.
  블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
- [] 플레이어는 게임을 시작할 때 배팅 금액을 정해야 한다.
  카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며,
  King, Queen, Jack은 각각 10으로 계산한다.
- [] 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며,
  두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다.
  21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
  단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.
- [] 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고,
  17점 이상이면 추가로 받을 수 없다.
- [] 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

## 2단계 요구사항

- [ ] 플레이어는 게임을 시작할 때 배팅 금액을 정해야 한다.
- [ ] 플레이어는 카드를 추가로 뽑아 21을 초과할 경우 **배팅 금액을 모두 잃게 된다.**
- [ ] 처음 두 장의 카드 합이 21일 경우 **베팅 금액의 1.5배를 딜러에게 받는다.**
    - [ ] 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 **베팅한 금액을 돌려받는다.**
- [ ] 딜러가 추가로 카드를 받을 때 21을 초과하면 그 시점까지 **남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리**해 베팅 금액을 받는다.

## 비기능적 요구사항

- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 `if`문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 `while`문을 사용한다면 depth가 2단계가 된다.
- `else`를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - 메소드가 한 가지 일만 하도록 최대한 작게 만들어라.
- 딜러와 플레이어에서 발생하는 중복 코드를 제거해야 한다.

##
- Participant(참가자) :
  field : String name, List<Card> cards, int cardNumberSum
  interface : 
  
* 흐름도 : 참여자 신청 -> 카드 분배 -> 참가자 마다 카드 지급여부 -> 총합 통계 ->  결과 표기 