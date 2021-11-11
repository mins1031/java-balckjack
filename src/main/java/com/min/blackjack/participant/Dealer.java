package com.min.blackjack.participant;

import com.min.blackjack.card.Card;

import java.util.List;

public class Dealer extends Participant{

    public Dealer(String name) {
        super(name);
    }

    public static List<Card> selectInitCard() {
        return null;
    }
}
