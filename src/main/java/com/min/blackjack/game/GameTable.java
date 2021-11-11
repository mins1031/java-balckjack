package com.min.blackjack.game;

import com.min.blackjack.participant.Participant;
import com.min.blackjack.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameTable {
    List<Participant> participants = new ArrayList<>();
//    * 흐름도 : 딜러생성 -> 참여자 신청 -> 카드 분배 -> 참가자 마다 카드 지급여부 -> 총합 통계 ->  결과 표기
    public void process() {
        recruitParticipant();
        allocateCards();
    }

    private void recruitParticipant() {
        List<String> participantNames = StringParser.parseParticipantName(InputView.inputParticipantNames());
        participants.addAll(participantNames.stream().map(name -> new Participant(name)).collect(Collectors.toList()));
    }

    private void allocateCards() {
//        new CardSelector().select();
    }
}
