package com.min.blackjack.participant;

import com.min.blackjack.card.Card;
import com.min.blackjack.card.CardValue;
import com.min.blackjack.game.GameTable;

import java.util.List;

public class Participant extends GameMember {
    public Participant(String name) {
        super(name);
    }
    
    public void decideTotalResult(Dealer dealer, int dealerScore) {
        if (dealerScore > GameTable.BLACKJACK_GOAL_SCORE) {
            dealer.setResult(GameTable.LOSS);
            if (this.getCardNumberSum() <= GameTable.BLACKJACK_GOAL_SCORE) {
                this.setResult(GameTable.WIN);
                return;
            }
            this.setResult(GameTable.LOSS);
            return;
        }

        if (this.getCardNumberSum() > GameTable.BLACKJACK_GOAL_SCORE) {
            this.setResult(GameTable.LOSS);
            dealer.setResult(GameTable.WIN);
            return;
        }

        if (this.getCardNumberSum() <= GameTable.BLACKJACK_GOAL_SCORE) {
            decideWinOrLoss(dealer, dealerScore);
        }
    }

    private void decideWinOrLoss(Dealer dealer, int dealerScore) {
        if (this.getCardNumberSum() < dealerScore) {
            this.setResult(GameTable.LOSS);
            dealer.setResult(GameTable.WIN);
        }

        if (this.getCardNumberSum() >= dealerScore) {
            this.setResult(GameTable.WIN);
            dealer.setResult(GameTable.LOSS);
        }
    }

}
