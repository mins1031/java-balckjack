package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.game.GameResult;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMember {
    public String name;
    public List<Card> cards = new ArrayList<>();
    public int cardNumberSum;
    public List<GameResult> results = new ArrayList<>();

    public GameMember(String name) {
        this.name = name;
    }

    public void calculateCardNumSum(Card card) {
        if (card.getCardValue() == CardValue.ACE) {
            distinguishAceValue();
            return;
        }
        cardNumberSum += card.getCardValue().getValue();
    }

    private void distinguishAceValue() {
        if (cardNumberSum > 11) {
            cardNumberSum++;
            return;
        }
        cardNumberSum += 10;
    }

    public void receiveInitCards(List<Card> cards) {
        this.cards = cards;
        cards.stream().map(card -> card.getCardValue().getValue()).forEach(cardValue -> cardNumberSum += cardValue);
    }

    public void addCard(Card card) {
        cards.add(card);
        calculateCardNumSum(card);
    }

    public void setResult(GameResult gameResult) {
        results.add(gameResult);
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

    public List<GameResult> getResults() {
        return results;
    }
}
