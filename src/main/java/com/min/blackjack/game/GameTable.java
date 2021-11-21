package com.min.blackjack.game;

import com.min.blackjack.participant.Dealer;
import com.min.blackjack.participant.Participant;
import com.min.blackjack.util.InputView;
import com.min.blackjack.util.OutputView;
import com.min.blackjack.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameTable {
    List<Participant> participants = new ArrayList<>();
    private final Dealer dealer = new Dealer();
    public final static String CARD_DRAW_VALUE = "y";
    public final static String NOT_CARD_DRAW_VALUE = "n";
    public final static int BLACKJACK_GOAL_SCORE = 21;
    public final static Boolean WIN = true;
    public final static Boolean LOSS = false;
//    * 흐름도 : 참여자 신청 -> 카드 분배 -> 참가자 마다 카드 지급여부 -> 총합 통계 ->  결과 표기

    public void process() {
        System.out.println("=============Game Start!=============");
        OutputView.guideParticipateGame();
        recruitParticipant(InputView.inputParticipantNames());
        allocateCards();
        askDrawCardToParticipant();
        informGameResult();
        completeGame(participants, dealer);
    }

    public void completeGame(List<Participant> participants, Dealer dealer) {
        int dealerScore = dealer.getCardNumberSum();

        for (Participant participant : participants) {
            participant.decideTotalResult(dealer, dealerScore);
        }

        OutputView.informGameResult(participants, dealer);
    }


    public void recruitParticipant(String rawParticipantNames) {
        List<String> participantNames = StringParser.parseParticipantName(rawParticipantNames);
        participants.addAll(participantNames.stream().map(name -> new Participant(name)).collect(Collectors.toList()));
    }

    public void allocateCards() {
        for (Participant participant : participants) {
            participant.receiveInitCards(dealer.selectInitCard());
        }
        dealer.receiveInitCards(dealer.selectInitCard());
    }

    private void askDrawCardToParticipant() {
        for (Participant participant : participants) {
            askAndDrawCard(participant);
            System.out.println(OutputView.informCards(participant));
        }

        dealer.drawDealerCard();
    }

    private void askAndDrawCard(Participant participant) {
        while (true) {
            if (InputView.inputDrawCardYesOrNo(participant.getName()).equals(NOT_CARD_DRAW_VALUE)) {
                break;
            }
            participant.addCard(dealer.drawNewCard());
        }
    }

    private void informGameResult() {
        for (Participant participant : participants) {
            OutputView.informParticipantsCardSum(participant);
        }
        OutputView.informParticipantsCardSum(dealer);
    }
}
