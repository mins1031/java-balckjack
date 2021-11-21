package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import java.util.List;

public interface GameMemberGuide {
    public void receiveInitCards(List<Card> cards);

    void calculateCardNumSum(Card card);
}