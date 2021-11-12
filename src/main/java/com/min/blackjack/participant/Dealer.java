package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.PorkerCardList;

import java.util.List;

public class Dealer extends Participant {
    private static final int INIT_CARD_COUNT = 2;
    private static final String DEALER_NAME = "DEALER";

    public Dealer() {
        super(DEALER_NAME);
    }

    public List<Card> selectInitCard() {
        PorkerCardList porkerCardList = new PorkerCardList();
        List<Card> initCards = porkerCardList.getRandomCards(INIT_CARD_COUNT);
        return initCards;
    }
}
