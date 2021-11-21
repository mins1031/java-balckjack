package com.min.blackjack.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PorkerCardListTest {

    @Test
    void name() {
        PorkerCardList porkerCardList = new PorkerCardList();

        Assertions.assertThat(porkerCardList.getCardList()).hasSize(52);
    }

    @Test
    @DisplayName("getRandomCards 메서드 테스트")
    void name2() {
        int requestNum = 2;
        PorkerCardList porkerCardList = new PorkerCardList();

        List<Card> randomCards = porkerCardList.getRandomCards(requestNum);
        Assertions.assertThat(randomCards).hasSize(2);
        Assertions.assertThat(porkerCardList.getCardList()).hasSize(50);
    }
}