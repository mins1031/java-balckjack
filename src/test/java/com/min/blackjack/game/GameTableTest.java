package com.min.blackjack.game;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardType;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.participant.Dealer;
import com.min.blackjack.participant.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    @DisplayName("딜러의 카드합이 21이하인 경우 정상 동작 테스트")
    void name2() {
        //given
        List<Participant> participants = Arrays.asList(new Participant("tony"), new Participant("kimilm"));
        Card card1 = new Card(CardType.CLOVER, CardValue.EIGHT);
        Card card2 = new Card(CardType.DIAMOND, CardValue.FIVE);
        Card card3 = new Card(CardType.CLOVER, CardValue.SEVEN);
        Card card4 = new Card(CardType.HART, CardValue.EIGHT);
        Card card5 = new Card(CardType.SPADE, CardValue.TEN);
        Dealer dealer = new Dealer();
        participants.get(0).addCard(card1);
        participants.get(0).addCard(card3); //15 1승
        participants.get(1).addCard(card4);
        participants.get(1).addCard(card5); //18 1승
        dealer.getCards().add(card1);
        dealer.getCards().add(card2); // 13  0승 2패
        //when
        GameTable gameTable = new GameTable();
        gameTable.completeGame(participants, dealer);
        //then
        Assertions.assertThat(participants.get(0).getResults().get(0)).isTrue();
        Assertions.assertThat(participants.get(1).getResults().get(0)).isTrue();
        Assertions.assertThat(dealer.getResults().get(0)).isFalse();
        Assertions.assertThat(dealer.getResults().get(1)).isFalse();
    }
}