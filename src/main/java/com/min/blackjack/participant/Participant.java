package com.min.blackjack.participant;

import com.min.blackjack.card.Card;

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
