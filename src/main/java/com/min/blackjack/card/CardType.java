package com.min.blackjack.card;

public enum CardType {
    HART("하트"),
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    SPADE("스페이드");

    private String name;

    CardType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
