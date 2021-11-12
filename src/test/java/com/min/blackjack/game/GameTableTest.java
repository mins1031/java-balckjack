package com.min.blackjack.game;

import com.min.blackjack.participant.Dealer;
import com.min.blackjack.participant.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTableTest {
    @Test
    @DisplayName("초기카드 2장 참가자 별로 배분 테스트")
    void name() {
        //given
        GameTable gameTable = new GameTable();
        String names = "tony,kimilm";
        Dealer dealer = new Dealer();
        //when
        gameTable.recruitParticipant(names);
        gameTable.allocateCards();
        //then
        List<Participant> participants = gameTable.participants;
        Assertions.assertThat(participants).hasSize(2);
        Assertions.assertThat(participants.get(0).getCards()).hasSize(2);
        Assertions.assertThat(participants.get(1).getCards()).hasSize(2);

    }
}