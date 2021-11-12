package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @Test
    void name() {
        //given
        Participant participant = new Participant("tony");
        Dealer dealer = new Dealer();
        participant.receiveInitCards(dealer.selectInitCard());
        //when
        participant.calculateCardNumSum();
        //then
        List<Card> cards = participant.getCards();
        Assertions.assertThat(participant.getCardNumberSum()).isEqualTo(cards.get(0).getCardValue().getValue() + cards.get(1).getCardValue().getValue());
    }
}