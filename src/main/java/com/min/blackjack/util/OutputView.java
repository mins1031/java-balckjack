package com.min.blackjack.util;

import com.min.blackjack.card.Card;
import com.min.blackjack.participant.Participant;

import java.util.List;

public class OutputView {
    private static final String GUIDANCE_PARTICIPATE_GAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String GUIDANCE_DRAW_CARD_BY_DEALER = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public static void guideParticipateGame() {
        System.out.println(GUIDANCE_PARTICIPATE_GAME);
    }

    public static void guideAllocatedCard(List<Participant> participants) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("딜러와 ");
        printParticipantName(participants, stringBuilder);
        stringBuilder.append("에게 2장의 카드를 나누어 주었습니다.");
        System.out.println(stringBuilder);
        for (Participant participant : participants) {
            printParticipantCardName(participant);
        }
    }

    private static void printParticipantName(List<Participant> participants, StringBuilder stringBuilder) {
        for (int i = 0; i < participants.size(); i++) {
            stringBuilder.append(participants.get(i).getName());
            if (i == (participants.size() - 1)) {
                break;
            }
            stringBuilder.append(", ");
        }
    }

    public static void askMoreCard(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    private static void printParticipantCardName(Participant participants) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(participants.getName() + "카드: ");
        for (Card card : participants.getCards()) {
            stringBuilder.append(card.toString());
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder);
    }

    public static StringBuilder informCards(Participant participant) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(participant.getName() + "카드: ");
        for (int i =0; i< participant.getCards().size(); i++) {
            stringBuilder.append(participant.getCards().get(i).toString());
            if (i == participant.getCards().size() - 1) {
                break;
            }
            stringBuilder.append(", ");
        }
        return stringBuilder;
    }

    public static void informDrawCardByDealer() {
        System.out.println(GUIDANCE_DRAW_CARD_BY_DEALER);
    }

    public static void informParticipantsCardSum(Participant participant) {
        StringBuilder cardSum = informCards(participant).append(" - ").append(participant.getCardNumberSum());
        System.out.println(cardSum);
    }

}
