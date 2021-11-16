package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.game.GameTable;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private int cardNumberSum;

    public Participant(String name) {
        this.name = name;
    }

    public void receiveInitCards(List<Card> cards) {
        this.cards = cards;
        cards.stream().map(card -> card.getCardValue().getValue()).forEach(cardValue -> cardNumberSum += cardValue);
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
