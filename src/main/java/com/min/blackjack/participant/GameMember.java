package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMember {
    public String name;
    public List<Card> cards = new ArrayList<>();
    public int cardNumberSum;

    public void calculateCardNumSum(Card card) {
        if (card.getCardValue() == CardValue.ACE) {
            distinguishAceValue();
        }
        cardNumberSum += card.getCardValue().getValue();
    }

    private void distinguishAceValue() {
        if (cardNumberSum > 11) {
            cardNumberSum++;
        }
        cardNumberSum += 10;
    }

    public void receiveInitCards(List<Card> cards) {
        this.cards = cards;
        cards.stream().map(card -> card.getCardValue().getValue()).forEach(cardValue -> cardNumberSum += cardValue);
    }

    public GameMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardNumberSum() {
        return cardNumberSum;
    }
}
