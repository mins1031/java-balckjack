package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.PorkerCardList;
import com.min.blackjack.game.GameResult;
import com.min.blackjack.util.OutputView;

import java.util.List;

public class Dealer extends GameMember {

    private static final int INIT_CARD_COUNT = 2;
    private static final int MORE_DRAW_CARD_COUNT = 1;
    private static final String DEALER_NAME = "DEALER";
    private static PorkerCardList porkerCardList = new PorkerCardList();

    public static final int DEALER_MIN_SCORE = 16;

    public Dealer() {
        super(DEALER_NAME);
    }

    public List<Card> selectInitCard() {
        List<Card> initCards = porkerCardList.getRandomCards(INIT_CARD_COUNT);
        return initCards;
    }

    public Card drawNewCard() {
        return porkerCardList.getRandomCards(MORE_DRAW_CARD_COUNT).get(0);
    }

    public void drawDealerCard() {
        while (true) {
            if (this.getCardNumberSum() > Dealer.DEALER_MIN_SCORE) {
                break;
            }
            OutputView.informDrawCardByDealer();
            Card drawNewCard = drawNewCard();
            getCards().add(drawNewCard);
            calculateCardNumSum(drawNewCard);
        }
    }

    public String collectGameResult() {
        int winCount = 0;
        int lossCount = 0;

        for (GameResult result : this.results) {
            if (result == GameResult.WIN) {
                winCount++;
                continue;
            }
            lossCount++;
        }

        return String.format("%d승 %d패", winCount, lossCount);
    }
}
