package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardType;
import com.min.blackjack.card.CardValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameMemberTest {

    @Test
    @DisplayName("참가자의 카드합이 12를 넘은상황에서 에이스 카드를 뽑은 경우")
    void name() {
        //given
        Participant participant = new Participant("tony");
        Card ten = new Card(CardType.CLOVER, CardValue.TEN);
        Card two = new Card(CardType.CLOVER, CardValue.TWO);
        Card ace = new Card(CardType.CLOVER, CardValue.ACE);

        participant.addCard(ten);
        participant.addCard(two);
        //when
        participant.addCard(ace);
        //then
        Assertions.assertThat(participant.getCardNumberSum()).isEqualTo(13);
    }

    @Test
    @DisplayName("참가자의 카드합이 11이하인 상황에서 에이스 카드를 뽑은 경우")
    void name2() {
        //given
        Participant participant = new Participant("tony");
        Card ten = new Card(CardType.CLOVER, CardValue.TEN);
        Card ace = new Card(CardType.CLOVER, CardValue.ACE);

        participant.addCard(ten);
        //when
        participant.addCard(ace);
        //then
        Assertions.assertThat(participant.getCardNumberSum()).isEqualTo(20);
    }
}