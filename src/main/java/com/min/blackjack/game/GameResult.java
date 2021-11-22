package com.min.blackjack.game;

public enum GameResult {
    WIN("승",true),
    LOSS("패",false);

    private String resultName;
    private Boolean resultValue;

    GameResult(String resultName, Boolean resultValue) {
        this.resultName = resultName;
        this.resultValue = resultValue;
    }

    public String getResultName() {
        return resultName;
    }

    public Boolean getResultValue() {
        return resultValue;
    }
}
