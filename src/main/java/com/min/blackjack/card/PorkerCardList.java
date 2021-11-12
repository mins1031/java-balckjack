package com.min.blackjack.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PorkerCardList {
    private List<Card> cardList = new ArrayList<>();
    private List<CardType> cardTypes = Arrays.asList(CardType.values());
    private List<CardValue> cardValues = Arrays.asList(CardValue.values());
    private int totalCardCount = 52;

    {
        for (CardType cardType : cardTypes) {
            cardList.addAll(cardValues.stream().map(cardValue -> new Card(cardType, cardValue)).collect(Collectors.toList()));
        }
    }

    public List<Card> getRandomCards(int requestCardNums) {
        List<Card> responseCard = new ArrayList<>();
        for (int i = 0; i < requestCardNums; i++) {
            int randomCardPosition = (int) (Math.random() * totalCardCount);
            responseCard.add(cardList.get(randomCardPosition));
            cardList.remove(randomCardPosition);
            totalCardCount--;
        }

        return responseCard;
    }

    public List<Card> getCardList() {
        return cardList;
    }

}
