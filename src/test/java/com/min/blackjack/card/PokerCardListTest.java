package com.min.blackjack.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PokerCardListTest {

    @Test
    void name() {
        PokerCardList pokerCardList = new PokerCardList();

        Assertions.assertThat(pokerCardList.getCardList()).hasSize(52);
    }

    @Test
    @DisplayName("getRandomCards 메서드 테스트")
    void name2() {
        int requestNum = 2;
        PokerCardList pokerCardList = new PokerCardList();

        List<Card> randomCards = pokerCardList.getRandomCards(requestNum);

        Assertions.assertThat(randomCards).hasSize(2);
        Assertions.assertThat(pokerCardList.getCardList()).hasSize(50);
    }
}