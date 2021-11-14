package com.min.blackjack.validator;

import com.min.blackjack.exception.InputWrongDrawCharException;
import com.min.blackjack.game.GameTable;

public class DrawCardValidation {
    public static void drawCardValidation(String answer) {
        if (!answer.equals(GameTable.CARD_DRAW_VALUE) && !answer.equals(GameTable.NOT_CARD_DRAW_VALUE)) {
            throw new InputWrongDrawCharException();
        }
    }
}
