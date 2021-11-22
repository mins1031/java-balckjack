package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.game.GameResult;
import com.min.blackjack.game.GameTable;

import java.util.List;

public class Participant extends GameMember {
    public Participant(String name) {
        super(name);
    }
    
    public void decideTotalResult(Dealer dealer, int dealerScore) {
        if (dealerScore > GameTable.BLACKJACK_GOAL_SCORE) {
            dealer.setResult(GameResult.LOSS);
            if (this.getCardNumberSum() <= GameTable.BLACKJACK_GOAL_SCORE) {
                this.setResult(GameResult.WIN);
                return;
            }
            this.setResult(GameResult.LOSS);
            return;
        }

        if (this.getCardNumberSum() > GameTable.BLACKJACK_GOAL_SCORE) {
            this.setResult(GameResult.LOSS);
            dealer.setResult(GameResult.WIN);
            return;
        }

        if (this.getCardNumberSum() <= GameTable.BLACKJACK_GOAL_SCORE) {
            decideWinOrLoss(dealer, dealerScore);
        }
    }

    private void decideWinOrLoss(Dealer dealer, int dealerScore) {
        if (this.getCardNumberSum() < dealerScore) {
            this.setResult(GameResult.LOSS);
            dealer.setResult(GameResult.WIN);
        }

        if (this.getCardNumberSum() >= dealerScore) {
            this.setResult(GameResult.WIN);
            dealer.setResult(GameResult.LOSS);
        }
    }

}
