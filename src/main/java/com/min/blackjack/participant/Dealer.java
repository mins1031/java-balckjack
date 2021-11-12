package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.PorkerCardList;

import java.util.List;

public class Dealer extends Participant {
    private static final int INIT_CARD_COUNT = 2;
    private static final int MORE_DRAW_CARD_COUNT = 1;
    private static final String DEALER_NAME = "DEALER";
    private static PorkerCardList porkerCardList = new PorkerCardList();

    public Dealer() {
        super(DEALER_NAME);
    }

    public List<Card> selectInitCard() {
        List<Card> initCards = porkerCardList.getRandomCards(INIT_CARD_COUNT);
        return initCards;
    }

    public Card addCard() {
        return porkerCardList.getRandomCards(MORE_DRAW_CARD_COUNT).get(0);
    }
}
