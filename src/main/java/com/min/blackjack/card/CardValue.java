package com.min.blackjack.card;

public enum CardValue {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    ACE("A"),
    QUEEN("Q"),
    KING("K");

    private String name;

    CardValue(String name) {
        this.name = name;
    }
}
