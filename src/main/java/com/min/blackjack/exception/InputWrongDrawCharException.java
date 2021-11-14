package com.min.blackjack.exception;

public class InputWrongDrawCharException extends RuntimeException {
    private static final String WRONG_DRAW_CHAR_MESSAGE = "카드 뽑기 여부는 y, n중 하나를 입력해야 합니다";

    public InputWrongDrawCharException() {
        super(WRONG_DRAW_CHAR_MESSAGE);
    }
}
