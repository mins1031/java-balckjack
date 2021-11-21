package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.game.GameTable;

import java.util.List;

public class Participant extends GameMember {

    public Participant(String name) {
        super(name);
    }


    public void addCard(Card card) {
        cards.add(card);
        calculateCardNumSum(card);
    }

    public boolean distinguishOverBlackJackGoalScore(Card card) {
        if (cardNumberSum + card.getCardValue().getValue() > GameTable.BLACKJACK_GOAL_SCORE) {
            return false;
        }
        return true;
    }

}
