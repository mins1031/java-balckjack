package com.min.blackjack.card;

public class Card {
    private CardType cardType;
    private CardValue cardValue;

    public Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return String.valueOf(cardValue) + String.valueOf(cardType);
    }
}
