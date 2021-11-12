package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DealerTest {

    @Test
    @DisplayName("selectInitCard메서드 테스트")
    void name() {
        //given
        Dealer dealer = new Dealer();
        //when
        List<Card> cards = dealer.selectInitCard();
        //then
        Assertions.assertThat(cards).hasSize(2);
    }
}