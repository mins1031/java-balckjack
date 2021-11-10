package com.min.blackjack.participant;

import java.util.ArrayList;

public class Participant {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private int cardNumberSum;

    public Participant(String name) {
        this.name = name;
    }
}
